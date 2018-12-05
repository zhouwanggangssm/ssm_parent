package cn.xt.controller.contracthis;

import cn.xt.domain.Contract;
import cn.xt.service.ContractHisService;
import cn.xt.utils.SysConstant;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * 历史购销合同
 */
@Controller
public class ContractHisController {
    @Resource
    private ContractHisService contractHisService;

    //归档
    @RequestMapping("/cargo/contracthis/pigeinhole")
    public String pigeinhole(String[] contractId){
        contractHisService.pigeinhole(contractId);
        return "redirect:/cargo/contracthis/list";
    }

    /**
     * 取消归档
     * @return
     */
    @RequestMapping("/cargo/contracthis/pigeouthole")
    public String pigeouthole(String[] contractId){
        contractHisService.pigeouthole(contractId);
        return "redirect:/cargo/contracthis/list";
    }

    /**
     * 历史列表
     * @return
     */
    @RequestMapping("/cargo/contracthis/list")
     public String list(@RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex,
                        Model model){
        //分页
        PageHelper.startPage(pageIndex, SysConstant.PAGE_SIZE);//传入当前页，跟每页显示多少条
        //调用查询方法
        List<Contract> list = contractHisService.findPage();
        //创建pageInfo
        PageInfo pageInfo = new PageInfo(list);
        model.addAttribute("results",pageInfo.getList());
        model.addAttribute("totalPageCount",pageInfo.getPages());//总页数
        model.addAttribute("totalCount",pageInfo.getTotal()); //总记录数
        model.addAttribute("currentPageNo",pageIndex);//当前页
        return "cargo/contracthis/jContractHisList";
    }

}


















