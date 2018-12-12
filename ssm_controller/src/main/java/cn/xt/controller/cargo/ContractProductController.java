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
import org.springframework.web.multipart.MultipartFile;

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
    @RequestMapping(value = "/contractProduct_tocreate",method = RequestMethod.GET)
    public String insertUI(ContractProduct contractProduct, Model model){

        //传递主表ID，同时作为查询条件
        model.addAttribute("contractId",contractProduct.getContractId());
        //厂家下拉列表 查询类型为‘货物’ 状态为 1
        List<Factory> list = contractProductService.factoryList("货物", "1");
        //放进作用域中
        model.addAttribute("factoryList",list);
        //厂家附件信息
        List<ContractProduct> contractProducts = contractProductService.queryListAll(contractProduct);
        //把附件信息存在作用域中
        model.addAttribute("results",contractProducts);
        return "cargo/contract/jContractProductCreate";
    }

    /**
     * 增加货物,上传图片
     * @param contractProduct
     * @return
     */
    @RequestMapping(value = "/contract_inserts",method = RequestMethod.POST)
    public String insertCP(ContractProduct contractProduct,@RequestParam("Image") MultipartFile Image){
        //货物照片
        contractProduct.setProductImage(Image.getOriginalFilename());

        //添加购销合同下的货物
        contractProductService.add(contractProduct);
        //重定向然后传入购销合同id
        return "redirect:/cargo/contractProduct_tocreate?contractId="+contractProduct.getContractId();
    }

    /**
     * 删除货物
     * @return
     */
    @RequestMapping(value = "/contractProduct_deletes")
    public String deleteCP(ContractProduct contractProduct) throws Exception {
        //调用删除方法
        contractProductService.delete(contractProduct);
        return "redirect:/cargo/contractProduct_tocreate?contractId="+contractProduct.getContractId();
    }

    /**
     * 修改页面
     * @param contractProductId
     * @param model
     * @return
     */
    @RequestMapping("/contractProduct_toupdates")
    public String toupdateUI(@RequestParam("contractProductId") String contractProductId,Model model){
        //修改页面回显的数据
        ContractProduct contractProduct = contractProductService.getContractProductById(contractProductId);
        model.addAttribute("contractProduct",contractProduct);

        //厂家下拉列表factoryList ‘货物’ 状态为1
        List<Factory> list = contractProductService.factoryList("货物", "1");
        //存在model中factoryList
        model.addAttribute("factoryList",list);
        return "cargo/contract/jContractProductUpdate";
    }

    /**
     * 修改货物信息
     * @return
     */
    @RequestMapping(value = "/contractProduct_updates",method = RequestMethod.PUT)
    public String updates(ContractProduct contractProduct){
        //调用修改方法
        contractProductService.update(contractProduct);
        return "redirect:/cargo/contractProduct_tocreate?contractId="+contractProduct.getContractId();
    }
}
