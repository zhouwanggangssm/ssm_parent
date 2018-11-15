package cn.xt.controller.cargo;

import cn.xt.domain.Contract;
import cn.xt.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cargo")
public class ContractController {
    @Autowired
    ContractService contractService;

    /**
     * 查询所有的购销合同
     * @param model
     * @return
     */
    @RequestMapping("/contract_list")
    public String list(Model model){
        List<Contract> list = contractService.findpage();
        model.addAttribute("results",list);
        return "cargo/contract/jContractList";
    }

    /**
     * 根据id查询一条记录
     * @param id
     * @return
     */
    @RequestMapping("/contract_toview")
    public String view(@RequestParam("id") String id){

        return "cargo/contract/jContractView";
    }
}
