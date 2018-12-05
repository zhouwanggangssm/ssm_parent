package cn.xt.controller.cargo;

import cn.xt.domain.Contract;
import cn.xt.domain.Export;
import cn.xt.domain.PackingList;
import cn.xt.domain.ShippingOrder;
import cn.xt.service.ExportService;
import cn.xt.service.PackingListService;
import cn.xt.service.ShippingOrderService;
import cn.xt.utils.DownloadUtil;
import cn.xt.utils.SysConstant;
import cn.xt.utils.UtilFuns;
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
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 委托
 */
@Controller
@RequestMapping("/cargo")
public class ShippingOrderController {
    @Autowired
    private ShippingOrderService shippingOrderService;
    @Autowired
    private PackingListService packingListService;
    @Autowired
    private ExportService exportService;
    /**
     * 查询委托
     * @return
     */
    @RequestMapping("/jshipping_list")
    public String list(@RequestParam(value = "pageIndex",required = false,defaultValue = "1") int pageIndex,
                       Model model){
        //使用分页的插件 pageHelper
        PageHelper.startPage(pageIndex, SysConstant.PAGE_SIZE);
        //传入当前页，每页显示10条
        List<ShippingOrder> list = shippingOrderService.findPage();
        //把查出来的数据放进pageInfo
        PageInfo pageInfo = new PageInfo(list);

        model.addAttribute("results",pageInfo.getList());//数据
        model.addAttribute("totalPageCount",pageInfo.getPages());//总页数
        model.addAttribute("totalCount",pageInfo.getTotal()); //总记录数
        model.addAttribute("currentPageNo",pageIndex);//当前页
        return "cargo/shippingorder/jShippingOrderList";
    }

    /**
     * 新增页面
     * @return
     */
    @RequestMapping("/shippingOrder_tocreate")
    public String toCreate(@RequestParam(value = "pageIndex",required = false,defaultValue = "1") int pageIndex,
                           Model model){
        PageHelper.startPage(pageIndex,SysConstant.PAGE_SIZE);
        //查询装箱为 1的信息
        List<PackingList> packingList = shippingOrderService.findPackingList(1);
        PageInfo pageInfo = new PageInfo(packingList);
        //放进model
        model.addAttribute("packingList",pageInfo.getList());//数据
        model.addAttribute("totalPageCount",pageInfo.getPages());//总页数
        model.addAttribute("totalCount",pageInfo.getTotal()); //总记录数
        model.addAttribute("currentPageNo",pageIndex);//当前页
        return "cargo/shippingorder/jShippingOrderCreate";
    }

    /**
     * 新增委托
     * @return
     */
    @RequestMapping(value = "shippingOrder_insert",method = RequestMethod.POST)
    public String create(ShippingOrder shippingOrder){
        shippingOrderService.insert(shippingOrder);
        return "redirect:/cargo/jshipping_list";
    }

    /**查看
     *
     * @return
     */
    @RequestMapping("/shippingOrder_view")
    public String view(String shippingOrderId,Model model){
        ShippingOrder shippingOrder = shippingOrderService.get(shippingOrderId);
        model.addAttribute("sOd",shippingOrder);
        return "cargo/shippingorder/jShippingOrderView";
    }

    /**
     * 修改页面
     * @param shippingOrderId
     * @param model
     * @return
     */
    @RequestMapping("/shippingOrder_toUpdate")
    public String toUpdate(String shippingOrderId,Model model){
        ShippingOrder shippingOrder = shippingOrderService.get(shippingOrderId);
        model.addAttribute("sOd",shippingOrder);
        return "cargo/shippingorder/jShippingOrderUpdate";
    }

    /**
     * 修改
     * @return
     */
    @RequestMapping(value = "/shippingOrder_update",method = RequestMethod.PUT)
    public String update(ShippingOrder shippingOrder){
        shippingOrderService.update(shippingOrder);
        return "redirect:/cargo/jshipping_list";
    }

    /**
     * 删除
     * @return
     */
    @RequestMapping(value = "/shippingOrder_delete",method = RequestMethod.DELETE)
    public String deletes(String shippingOrderId){
        List<String> list = new ArrayList<>();
        if(shippingOrderId.contains(",")){
            String[] ids = shippingOrderId.split(",");
            for(int i = 0; i<ids.length;i++){
                //放入集合中
                list.add(ids[i]);
            }
            //批量删除
            shippingOrderService.deleteBarch(list);
        }else{
            //删除单个
            shippingOrderService.delete(shippingOrderId);
        }
        return "redirect:/cargo/jshipping_list";
    }

    /**
     * 提交
     * @return
     */
    @RequestMapping("/shippingOrder_submit")
    public String submit(String shippingOrderId){
        this.changeState(1,shippingOrderId.split(","));
        return "redirect:/cargo/jshipping_list";
    }

    /**
     * 取消
     * @return
     */
    @RequestMapping("/shippingOrder_cancel")
    public String cancel(String shippingOrderId){
        this.changeState(0,shippingOrderId.split(","));
        return "redirect:/cargo/jshipping_list";
    }

    /**
     * 改变状态
     */
    private void changeState(Integer state,String[] ids){
        Map<String,Object> map = new HashMap<>();
        map.put("state",state);
        map.put("ids",ids);
        shippingOrderService.updateStates(map);
    }

    /**
     * 装箱后发票按钮
     * @return
     */
    @RequestMapping("/shippingOrder_finish")
    public String finance(String shippingOrderId){
        ShippingOrder shippingOrder = shippingOrderService.get(shippingOrderId);
        //状态改为2
        shippingOrder.setState(2);
        //更新
        shippingOrderService.update(shippingOrder);
        return "redirect:/cargo/jshipping_list";
    }

    /**
     * 打印
     */
    @RequestMapping("/shippingOrder_toPrint")
    public String toPrint(String shippingOrderId,
            HttpServletRequest request,
            HttpServletResponse response)throws Exception{
        //通用变量
        int rowNo = 0,cellNo = 1;
        //定义行
        Row nRow = null;
        //定义列
        Cell nCell = null;

        //1.读取工作簿
       String path =  request.getSession().getServletContext().getRealPath("/") + "/make/xlsprint/tSHIPPINGORDER.xls";
        //输入流
        InputStream is = new FileInputStream(path);
        Workbook wb = new HSSFWorkbook(is);

        //2.读取工作表
        Sheet sheet = wb.getSheetAt(0);

        //读取数据
        //根据id查询委托单
        String[] ids = shippingOrderId.split(",");
        if(ids.length != 1){
            return "redirect:/cargo/jshipping_list";
        }
        //查询委托单对象
        ShippingOrder shippingOrder = shippingOrderService.get(shippingOrderId);
        //查询装箱单对象
        PackingList packingList = packingListService.get(shippingOrderId);
        //查询报运单对象
        String[] exportIds = packingList.getExportIds().split("\\|");
        Export export = null;
        for (int i =0;i<exportIds.length;i++){
             export = exportService.get(exportIds[0]);
        }

        //货主
        nRow = sheet.getRow(3);
        nCell = nRow.getCell(0);
        nCell.setCellValue(shippingOrder.getShipper());

        //提单抬头
        nRow = sheet.getRow(8);
        nCell = nRow.getCell(2);
        nCell.setCellValue(shippingOrder.getConsignee());

        //正本通知人
        nRow = sheet.getRow(15);
        nCell = nRow.getCell(0);
        nCell.setCellValue(shippingOrder.getNotifyParty());

        //发票号
        nRow = sheet.getRow(19);
        nCell = nRow.createCell(0);
        nCell.setCellValue(packingList.getInvoiceNo());


        //填写日期
        nRow = sheet.getRow(19);
        nCell = nRow.createCell(3);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(packingList.getInvoiceDate());
        nCell.setCellValue(format);

        //信用证号
        nRow = sheet.getRow(19);
        nCell = nRow.createCell(6);
        nCell.setCellValue(shippingOrder.getLcNo());

        //船运港
        nRow = sheet.getRow(23);
        nCell = nRow.createCell(0);
        nCell.setCellValue(shippingOrder.getPortOfLoading());

        //转船运
        nRow = sheet.getRow(23);
        nCell = nRow.createCell(3);
        nCell.setCellValue(shippingOrder.getPortOfTrans());

        //卸货港
        nRow = sheet.getRow(23);
        nCell = nRow.createCell(3);
        nCell.setCellValue(shippingOrder.getPortOfTrans());

        //装期
        nRow = sheet.getRow(27);
        nCell = nRow.createCell(0);
        nCell.setCellValue(UtilFuns.dateTimeFormat(shippingOrder.getLoadingDate()));

        //效期
        nRow = sheet.getRow(27);
        nCell = nRow.createCell(2);
        nCell.setCellValue(UtilFuns.dateTimeFormat(shippingOrder.getLimitDate()));

        //分批
        nRow = sheet.getRow(27);
        nCell = nRow.createCell(3);
        nCell.setCellValue(shippingOrder.getIsBatch());

        //转船
        nRow = sheet.getRow(27);
        nCell = nRow.createCell(5);
        nCell.setCellValue(shippingOrder.getIsTrans());

        //份数
        nRow = sheet.getRow(27);
        nCell = nRow.createCell(7);
        nCell.setCellValue(shippingOrder.getCopyNum());

        //唛头
        nRow = sheet.getRow(31);
        nCell = nRow.createCell(0);
        nCell.setCellValue(packingList.getMarks());

        //描述
        nRow = sheet.getRow(31);
        nCell = nRow.createCell(3);
        nCell.setCellValue(packingList.getDescriptions());

        //总箱数
        nRow = sheet.getRow(31);
        nCell = nRow.createCell(5);
        nCell.setCellValue(export.getBoxNums());

        //总重量
        nRow = sheet.getRow(31);
        nCell = nRow.createCell(6);
        nCell.setCellValue(export.getGrossWeights());

        //体积
     /*   nRow = sheet.getRow(31);
        nCell = nRow.createCell(8);
        nCell.setCellValue(export.getMeasurements());*/

        //运输要求
        nRow = sheet.getRow(37);
        nCell = nRow.createCell(1);
        nCell.setCellValue(shippingOrder.getSpecialCondition());

     // ====================调用工具类下载======================
        DownloadUtil downloadUtil = new DownloadUtil();
        //创建ByteArrayOutputStream对象
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        wb.write(baos);
        baos.close();
        downloadUtil.download(baos,response,request,"委托单.xls");
        return null;
    }
}
















