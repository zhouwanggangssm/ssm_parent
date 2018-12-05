package cn.xt.controller.cargo;

import cn.xt.domain.Invoice;
import cn.xt.domain.PackingList;
import cn.xt.domain.ShippingOrder;
import cn.xt.service.InvoiceService;
import cn.xt.service.PackingListService;
import cn.xt.service.ShippingOrderService;
import cn.xt.utils.DownloadUtil;
import cn.xt.utils.SysConstant;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/cargo")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private ShippingOrderService shippingOrderService;
    @Autowired
    private PackingListService packingListService;
    /**
     * 查询所有发票
     * @param pageIndex
     * @param model
     * @return
     */
    @RequestMapping("/invoice_list")
    public String list(@RequestParam(value = "pageIndex",required = false,defaultValue = "1") int pageIndex, Model model){
        //使用分页的插件 pageHelper
        PageHelper.startPage(pageIndex, SysConstant.PAGE_SIZE);
        //传入当前页，每页显示10条
        List<Invoice> list = invoiceService.findPage();
        //把查出来的数据放进pageInfo
        PageInfo pageInfo = new PageInfo(list);

        model.addAttribute("results",pageInfo.getList());//数据
        model.addAttribute("totalPageCount",pageInfo.getPages());//总页数
        model.addAttribute("totalCount",pageInfo.getTotal()); //总记录数
        model.addAttribute("currentPageNo",pageIndex);//当前页
        return "cargo/invoicelist/jInvoiceListPage";
    }

    /**
     * 新增页面
     * @param pageIndex
     * @param model
     * @return
     */
    @RequestMapping("/invoice_tocreate")
    public String toCreate(@RequestParam(value = "pageIndex",required = false,defaultValue = "1") int pageIndex,
                           Model model) {
        PageHelper.startPage(pageIndex, SysConstant.PAGE_SIZE);
        //查询委托为2的信息
        List<ShippingOrder> shippingList = invoiceService.findShippingList();
        PageInfo pageInfo = new PageInfo(shippingList);
        //放进model
        model.addAttribute("invoiceList", pageInfo.getList());//数据
        model.addAttribute("totalPageCount", pageInfo.getPages());//总页数
        model.addAttribute("totalCount", pageInfo.getTotal()); //总记录数
        model.addAttribute("currentPageNo", pageIndex);//当前页
        return "cargo/invoicelist/jInvoiceCreate";
    }

    /**
     * 新增发票
     * @param invoice
     * @return
     */
    @RequestMapping(value = "/invoice_insert",method = RequestMethod.POST)
    public String create(Invoice invoice){
        invoiceService.insert(invoice);
        return "redirect:/cargo/invoice_list";
    }

    /**查看
     *
     * @return
     */
    @RequestMapping("/invoice_toview")
    public String view(String invoiceId,Model model){
        Invoice invoice = invoiceService.get(invoiceId);
        model.addAttribute("invoice",invoice);
        return "cargo/invoicelist/jInvoiceView";
    }

    /**
     * 修改页面
     * @param invoiceId
     * @param model
     * @return
     */
    @RequestMapping("/invoice_toupdate")
    public String toUpdate(String invoiceId,Model model){
        Invoice invoice = invoiceService.get(invoiceId);
        model.addAttribute("invoice",invoice);
        return "cargo/invoicelist/jInvoiceUpdate";
    }

    /**
     * 修改
     * @param invoice
     * @return
     */
    @RequestMapping(value = "/invoice_update",method = RequestMethod.PUT)
    public String updates(Invoice invoice){
        invoiceService.update(invoice);
        return "redirect:/cargo/invoice_list";
    }

    /**
     * 删除
     * @return
     */
    @RequestMapping(value = "/invoice_delete",method = RequestMethod.DELETE)
    public String deletes(String invoiceId){
        List<String> list = new ArrayList<>();
        if(invoiceId.contains(",")){
            String[] ids = invoiceId.split(",");
            for(int i = 0; i<ids.length;i++){
                //放入集合中
                list.add(ids[i]);
            }
            //批量删除
            invoiceService.deleteBarch(list);
        }else{
            //删除单个
            invoiceService.delete(invoiceId);
        }
        return "redirect:/cargo/invoice_list";
    }

    /**
     * 提交
     * @return
     */
    @RequestMapping("/invoice_submit")
    public String submit(String invoiceId){
        this.changeState(1,invoiceId.split(","));
        return "redirect:/cargo/invoice_list";
    }

    /**
     * 取消
     * @return
     */
    @RequestMapping("/invoice_cancel")
    public String cancel(String invoiceId){
        this.changeState(0,invoiceId.split(","));
        return "redirect:/cargo/invoice_list";
    }

    /**
     * 改变状态
     */
    private void changeState(Integer state,String[] ids){
        Map<String,Object> map = new HashMap<>();
        map.put("state",state);
        map.put("ids",ids);
        invoiceService.updateStates(map);
    }

    /**
     * 财务按钮
     * @return
     */
    @RequestMapping("/invoice_changes")
    public String invoiceChange(String invoiceId){
        //查询发票的状态
        Invoice invoice = invoiceService.get(invoiceId);
        //设为2
        invoice.setState(2);
        //更新
        invoiceService.update(invoice);
        return "redirect:/cargo/invoice_list";
    }

    /**
     * 打印发票单
     * @return
     */
    @RequestMapping("/invoice_print")
    public String toPrint(String invoiceId, HttpServletRequest request, HttpServletResponse response)throws Exception{
        // 通用变量
        int rowNo = 0, cellNo = 1;
        Row nRow = null;
        Cell nCell = null;

        // 1.读取工作簿
        String path = request.getSession().getServletContext().getRealPath("/") + "/make/xlsprint/tINVOICE.xls";
        // 输入流
        InputStream is = new FileInputStream(path);
        Workbook wb = new HSSFWorkbook(is);

        // 2.读取工作表
        Sheet sheet = wb.getSheetAt(0);
        //===========读取数据
        //根据id查询委托单
        String[] ids = invoiceId.split(", ");
        if (ids.length!=1) {
            return "redirect:/cargo/invoice_list";
        }
        //发票对象
        Invoice invoice = invoiceService.get(invoiceId);
        //装箱对象
        PackingList packingList = packingListService.get(invoiceId);
        //委托对象
        ShippingOrder shippingOrder = shippingOrderService.get(invoiceId);
        nRow = sheet.getRow(3);
        nCell = nRow.getCell(1);
        nCell.setCellValue(packingList.getSeller());

        nRow = sheet.getRow(8);
        nCell = nRow.getCell(1);
        nCell.setCellValue(packingList.getBuyer());

        nRow = sheet.getRow(15);
        nCell = nRow.getCell(8);
        nCell.setCellValue(invoice.getBlNo());


        //信用证
        nRow = sheet.getRow(19);
        nCell = nRow.createCell(1);
        nCell.setCellValue(shippingOrder.getLcNo());

        //日期
        nRow = sheet.getRow(15);
        nCell = nRow.createCell(2);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String format = df.format(new Date());
        nCell.setCellValue(format);
        //信用证号
        nRow = sheet.getRow(19);
        nCell = nRow.createCell(6);
        nCell.setCellValue(shippingOrder.getLcNo());

        //唛头
        nRow = sheet.getRow(23);
        nCell = nRow.createCell(1);
        nCell.setCellValue(packingList.getMarks());

        //描述
        nRow = sheet.getRow(23);
        nCell = nRow.createCell(2);
        nCell.setCellValue(packingList.getDescriptions());
        //合同号
        nRow = sheet.getRow(15);
        nCell = nRow.createCell(5);
        nCell.setCellValue(invoice.getScNo());

        nRow = sheet.getRow(15);
        nCell = nRow.createCell(9);
        nCell.setCellValue(invoice.getBlNo());

        //装运港
        nRow = sheet.getRow(19);
        nCell = nRow.createCell(5);
        nCell.setCellValue(shippingOrder.getPortOfLoading());

        //目的港
        nRow = sheet.getRow(19);
        nCell = nRow.createCell(9);
        nCell.setCellValue(shippingOrder.getPortOfDischarge());




        // ======================================输出到客户端（下载）========================================
        DownloadUtil downUtil = new DownloadUtil();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();// 流 内存中的缓存区
        wb.write(baos);// 将excel表格中的内容输出到缓存
        baos.close();// 刷新缓存

        downUtil.download(baos, response,request, "发票单.xlsx");// 如果是中文，下载时可能会产生乱码，如何解决？
        return  null;
    }
}

























