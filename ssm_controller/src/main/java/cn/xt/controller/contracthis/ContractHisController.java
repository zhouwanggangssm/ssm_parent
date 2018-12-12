package cn.xt.controller.contracthis;

import cn.xt.domain.Contract;
import cn.xt.service.ContractHisService;
import cn.xt.utils.SysConstant;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
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
        //传入contractId数组
        contractHisService.pigeinhole(contractId);
        return "redirect:/cargo/contracthis/list";
    }

    /**
     * 取消归档
     * @return
     */
    @RequestMapping("/cargo/contracthis/pigeouthole")
    public String pigeouthole(String[] contractId){
        //传入contractId数组
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

    /**
     * 查看历史购销合同
     * @return
     */
    @RequestMapping("/cargo/contracthis_toview")
    public String views(String contractId, Model model){
        //根据contractId查询
        Contract contract = contractHisService.view(contractId);
        model.addAttribute("contract",contract);
        return "cargo/contract/jContractView";
    }

    /**
     * 输出历史购销合同
     * @return
     */
    @RequestMapping(value = "/cargo/contracthis_delete" ,method = RequestMethod.DELETE)
    public String delete(String contractId){
        //创建list集合
        List<String> list = new ArrayList<>();
        if(contractId.contains(",")){
            String[] ids = contractId.split(",");
            for(int i = 0; i<ids.length;i++){
                //放入集合中
                list.add(ids[i]);
            }
            //批量删除
            contractHisService.deleteBarch(list);
        }else{
            //删除单个
            contractHisService.delete(contractId);
        }
        return "redirect:/cargo/contracthis/list";
    }
}


















