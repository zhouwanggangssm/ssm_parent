package cn.xt.controller.cargo;

import cn.xt.domain.Finance;
import cn.xt.domain.Invoice;
import cn.xt.domain.PackingList;
import cn.xt.domain.ShippingOrder;
import cn.xt.service.FinanceService;
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
public class FinanceController {
    @Autowired
    private FinanceService financeService;
    /**
     * 查询所有发票
     * @param pageIndex
     * @param model
     * @return
     */
    @RequestMapping("/finance_list")
    public String list(@RequestParam(value = "pageIndex",required = false,defaultValue = "1") int pageIndex, Model model){
        //使用分页的插件 pageHelper
        PageHelper.startPage(pageIndex, SysConstant.PAGE_SIZE);
        //传入当前页，每页显示10条
        List<Finance> financeList = financeService.findPage();
        //把查出来的数据放进pageInfo
        PageInfo pageInfo = new PageInfo(financeList);

        model.addAttribute("results",pageInfo.getList());//数据
        model.addAttribute("totalPageCount",pageInfo.getPages());//总页数
        model.addAttribute("totalCount",pageInfo.getTotal()); //总记录数
        model.addAttribute("currentPageNo",pageIndex);//当前页
        return "cargo/finance/jFinanceListPage";
    }

   /**
     * 新增页面
     * @param pageIndex
     * @param model
     * @return
     */
    @RequestMapping("/finance_tocreate")
    public String toCreate(@RequestParam(value = "pageIndex",required = false,defaultValue = "1") int pageIndex,
                           Model model) {
        PageHelper.startPage(pageIndex, SysConstant.PAGE_SIZE);
        //查询委托为2的信息
        List<Invoice> invoiceList = financeService.findInvoiceList();
        PageInfo pageInfo = new PageInfo(invoiceList);
        //放进model
        model.addAttribute("invoiceList", pageInfo.getList());//数据
        model.addAttribute("totalPageCount", pageInfo.getPages());//总页数
        model.addAttribute("totalCount", pageInfo.getTotal()); //总记录数
        model.addAttribute("currentPageNo", pageIndex);//当前页
        return "cargo/finance/jFinanceCreate";
    }

   /**
     * 新增发票
     * @param finance
     * @return
     */
    @RequestMapping(value = "/finance_insert",method = RequestMethod.POST)
    public String create(Finance finance){
        financeService.insert(finance);
        return "redirect:/cargo/finance_list";
    }

    /**查看
     *
     * @return
     */
   @RequestMapping("/finance_toview")
    public String view(String financeId,Model model){
       Finance finance = financeService.get(financeId);
       model.addAttribute("finance",finance);
        return "cargo/finance/jFinanceView";
    }

     /**
     * 修改页面
     * @param financeId
     * @param model
     * @return
     */
    @RequestMapping("/finance_toupdate")
    public String toUpdate(String financeId,Model model){
        Finance finance = financeService.get(financeId);
        model.addAttribute("finance",finance);
        return "cargo/finance/jFinanceUpdate";
    }

    /**
     * 修改
     * @param finance
     * @return
     */
    @RequestMapping(value = "/finance_update",method = RequestMethod.PUT)
    public String updates(Finance finance){
        financeService.update(finance);
        return "redirect:/cargo/finance_list";
    }

    /**
     * 删除
     * @return
     */
    @RequestMapping(value = "/finance_delete",method = RequestMethod.DELETE)
    public String deletes(String financeId){
        List<String> list = new ArrayList<>();
        if(financeId.contains(",")){
            String[] ids = financeId.split(",");
            for(int i = 0; i<ids.length;i++){
                //放入集合中
                list.add(ids[i]);
            }
            //批量删除
            financeService.deleteBarch(list);
        }else{
            //删除单个
            financeService.delete(financeId);
        }
        return "redirect:/cargo/finance_list";
    }

    /**
     * 提交
     * @return
     */
    @RequestMapping("/finance_submit")
    public String submit(String financeId){
        this.changeState(1,financeId.split(","));
        return "redirect:/cargo/finance_list";
    }

    /**
     * 取消
     * @return
     */
    @RequestMapping("/finance_cancel")
    public String cancel(String financeId){
        this.changeState(0,financeId.split(","));
        return "redirect:/cargo/finance_list";
    }

    /**
     * 改变状态
     */
    private void changeState(Integer state,String[] ids){
        Map<String,Object> map = new HashMap<>();
        map.put("state",state);
        map.put("ids",ids);
        financeService.updateStates(map);
    }
}

























