package cn.xt.controller.cargo;

import cn.xt.domain.Contract;
import cn.xt.print.ContractPrint;
import cn.xt.print.ContractPrintTemplate;
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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

/**
 * 购销合同
 */
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
        //把数据放进作用域中
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
        //调用业务层查询方法
        Contract contract = contractService.getIdInfo(id);
        //把对象放进作用域
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
        //id
        contract.setContractId(uuid);
        //创建时间
       contract.setCreateTime(new Date());
       //总金额默认为 0d
        contract.setTotalAmount(0d);
        contract.setState(0); //0草稿 1已上报 2已报运
        //添加
        contractService.add(contract);
        return "redirect:/cargo/contract_list";
    }

    /**
     * 购销合同修改页面
     * @return
     */
    @RequestMapping("/contract_toupdateUI")
    public String updateUI(@RequestParam("contractId") String id,Model model){
        //调用查询方法
        Contract contract = contractService.get(id);
        //回显数据
        model.addAttribute("contract",contract);
        return "cargo/contract/jContractUpdate";
    }

    /**
     * 修改购销合同
     * @return
     */
    @RequestMapping(value = "/contract_update",method = RequestMethod.PUT)
    public String updateContract(Contract contract){
        //修改购销合同
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
        //判断ids是否包含，
        if (ids.contains(",")){
            //ids存放在String数组中,然后split分割 ，
            String[] idss = ids.split(",");
            //组装id的集合 循坏
            for (String i : idss){
                //放进list中
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
        this.changeState(1,id.split(","));
        return "redirect:/cargo/contract_list";
    }

    /**
     * 取消
     * @return
     */
    @RequestMapping("/contract_cancel")
    public String cancel(@RequestParam("contractId") String id){
        //传入id,状态：0 表示草稿
        this.changeState(0,id.split(","));
        return "redirect:/cargo/contract_list";
    }

    /**
     * 改变状态
     * 1上报
     * 0草稿
     * @param stateValue
     * @param ids
     */
    private void changeState(Integer stateValue,String[]ids){
        //创建map集合
        Map<String,Object> map = new HashMap<>();
        //把state放进map中
        map.put("state",stateValue);
        //把ids放进map
        map.put("ids",ids);
        //调用修改方法
        contractService.updateState(map);
    }

    /**
     * 购销合同打印
     */
    @RequestMapping("/contract_print")
    public void print(String contractId, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //实例化打印的工具类ContractPrint
        ContractPrint cp = new ContractPrint();
        //得到要打印的数据调用getIdInfo
        Contract contract = contractService.getIdInfo(contractId);
        //调用模板打印的方法 把路径/传过去
        cp.print(contract,request.getSession().getServletContext().getRealPath("/"),request,response);
    }
}



















