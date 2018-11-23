package cn.xt.controller.cargo;

import cn.xt.domain.Contract;
import cn.xt.service.ContractService;
import cn.xt.utils.SysConstant;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/cargo")
public class ContractController {
    @Autowired
    private ContractService contractService;

    /**
     * 查询所有的购销合同,分页查询
     * @param model
     * @return
     */
    @RequestMapping("/contract_list")
    public String list(@RequestParam(value = "pageIndex",required = false,defaultValue = "1") int pageIndex,
                       Model model){
        //使用分页的插件 pageHelper
        PageHelper.startPage(pageIndex, SysConstant.PAGE_SIZE);
        //传入当前页，每页显示10条
        List<Contract> list = contractService.findpage();
        //把查出来的数据放进pageInfo
        PageInfo pageInfo = new PageInfo(list);

        model.addAttribute("results",pageInfo.getList());//数据
        model.addAttribute("totalPageCount",pageInfo.getPages());//总页数
        model.addAttribute("totalCount",pageInfo.getTotal()); //总记录数
        model.addAttribute("currentPageNo",pageIndex);//当前页
        return "cargo/contract/jContractList";
    }

    /**
     * 根据id查询一条记录
     * @param id
     * @return
     */
    @RequestMapping("/contract_toview")
    public String view(@RequestParam("contractId") String id, Model model){
        Contract contract = contractService.getIdInfo(id);
        model.addAttribute("contract",contract);
        return "cargo/contract/jContractView";
    }

    /**
     * 购销合同新增页面
     * @return
     */
    @RequestMapping(value = "/contract_tocreate")
    public String insertUI(){
        return "cargo/contract/jContractCreate";
    }

    /**
     * 添加购销合同
     * @return
     */
    @RequestMapping(value ="/contract_insert",method = RequestMethod.POST)
    public String addContract(Contract contract){
        //用uuid生成id
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-","");
        contract.setContractId(uuid);
        //总金额
        //创建时间
       contract.setCreateTime(new Date());
        contract.setUpdateTime(new Date());
        contract.setTotalAmount(0d);
        contract.setState(0); //0草稿 1已上报 2已报运
            contractService.add(contract);
            return "redirect:/cargo/contract_list";
    }

    /**
     * 购销合同修改页面
     * @return
     */
    @RequestMapping("/contract_toupdateUI")
    public String updateUI(@RequestParam("contractId") String id,Model model){
        Contract contract = contractService.getIdInfo(id);
        model.addAttribute("contract",contract);
        return "cargo/contract/jContractUpdate";
    }

    /**
     * 修改购销合同
     * @return
     */
    @RequestMapping(value = "/contract_update",method = RequestMethod.PUT)
    public String updateContract(Contract contract){
            contractService.update(contract);
            return "redirect:/cargo/contract_list";

    }

    /**
     * 删除购销合同
     * @param ids
     * @return
     */
    @RequestMapping(value = "/contract_delete",method = RequestMethod.DELETE)
    public String deleteContract(@RequestParam("contractId") String ids){
        //创建String类型list集合
        List<String> list = new ArrayList<>();
        if (ids.contains(",")){
            //ids存放在String数组中,然后split分割
            String[] idss = ids.split(",");
            //组装id的集合
            for (String i : idss){
                list.add(i);
            }
            //批量删除
            contractService.deleteBatch(list);
        }else{
            //单个删除
            contractService.delete(ids);
        }
         return "redirect:/cargo/contract_list";
    }

    /**
     * 购销合同提交
     * @return
     */
    @RequestMapping("/contract_submit")
    public String submit(@RequestParam("contractId") String id){
        //传入id,状态：1 表示已上报
        contractService.changeState(id,1);
        return "redirect:/cargo/contract_list";
    }

    /**
     * 取消
     * @return
     */
    @RequestMapping("/contract_cancel")
    public String cancel(@RequestParam("contractId") String id){
        //传入id,状态：0 表示草稿
        contractService.changeState(id,0);
        return "redirect:/cargo/contract_list";
    }

}
