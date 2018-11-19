package cn.xt.controller.cargo;

import cn.xt.domain.ContractProduct;
import cn.xt.domain.Factory;
import cn.xt.service.ContractProductService;
import cn.xt.utils.UtilFuns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/cargo")
public class ContractProductController {
    @Autowired
    ContractProductService contractProductService;

    /**
     * 添加货物页面，显示厂家下拉列表，跟厂家信息，附件信息
     * @param model
     * @return
     */
    @RequestMapping(value = "/contractProduct_tocreate/{contractId}",method = RequestMethod.GET)
    public String insertUI(@PathVariable String contractId, Model model){
        //厂家下拉列表
        List<Factory> list = contractProductService.factoryList("货物", "1");
        model.addAttribute("factoryList",list);
        //厂家附件信息
        List<ContractProduct> contractProducts = contractProductService.queryListAll(contractId);
        model.addAttribute("results",contractProducts);
        return "cargo/contract/jContractProductCreate";
    }

    /**
     * 增加货物
     * @param contractProduct
     * @return
     */
    @RequestMapping(value = "/contract_inserts",method = RequestMethod.POST)
    public String insertCP(ContractProduct contractProduct){
        contractProductService.add(contractProduct);
        return "redirect:/cargo/contractProduct_tocreate/"+contractProduct.getContractId();
    }

    /**
     * 删除货物
     * @return
     */
    @RequestMapping("/contractProduct_deletes")
    public String deleteCP(@RequestParam("contractProductId") String contractProductId,@RequestParam("contractId") String contractId){

        return "redirect:/cargo/contractProduct_tocreate/"+contractId;
    }
}
