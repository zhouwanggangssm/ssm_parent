package cn.xt.controller.cargo;

import cn.xt.domain.ContractProduct;
import cn.xt.domain.ExtCproduct;
import cn.xt.domain.Factory;
import cn.xt.service.ExtCproductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cargo")
public class ExtCproductController {
    @Autowired
    private ExtCproductService extCproductService;
    /**
     * 添加货物页面，显示厂家下拉列表，跟货物信息，附件信息
     * @param model
     * @return
     */
    @RequestMapping(value = "/extCproduct_tocreates",method = RequestMethod.GET)
    public String insertUI(@RequestParam("contractProductId") String contractProductId,
                           @RequestParam(value = "contractId",required = false) String contractId,
                           Model model, HttpSession session){
        //厂家下拉列表
        List<Factory> list = extCproductService.factoryList("附件", "1");
        model.addAttribute("factoryList",list);
        //厂家附件信息
        List<ExtCproduct> extCproducts = extCproductService.queryListAll(contractProductId);
        model.addAttribute("results",extCproducts);
        //把contractId存进作用域中
        /*model.addAttribute("contractId",contractId);*/
        session.setAttribute("contractId",contractId);

        //把contractProductId存进作用域中
        model.addAttribute("contractProductId",contractProductId);
        return "cargo/contract/jExtCproductCreate";
    }

    /**
     * 增加附件
     * @param extCproduct
     * @return
     */
    @RequestMapping(value = "/extCproduct_inserts",method = RequestMethod.POST)
    public String insertCP(ExtCproduct extCproduct,RedirectAttributes redirectAttributes){
        extCproductService.add(extCproduct);
        //重定向携带contractProductId参数
        redirectAttributes.addAttribute("contractProductId",extCproduct.getContractProductId());

        redirectAttributes.addAttribute("contractId",extCproduct.getContractProduct().getContract().getContractId());
        return "redirect:/cargo/extCproduct_tocreates";
    }

    /**
     * 修改页面
     * 传入extCproductId跟contractId
     * @return
     */
    @RequestMapping("/extCproduct_toupdates")
    public String toUpdateUI(@RequestParam("extCproductId") String extCproductId,
                             @RequestParam("contractId") String contractId,
                             Model model){
        //附件信息回显数据
        ExtCproduct extCproduct = extCproductService.getExtCproductById(extCproductId);
        model.addAttribute("extCproduct",extCproduct);

        //把contractId放进作用域
        /*model.addAttribute("contractId",contractId);*/

        //厂家下拉列表
        List<Factory> list = extCproductService.factoryList("附件", "1");
        model.addAttribute("factoryList",list);
        return "cargo/contract/jExtCproductUpdate";
    }

    /**
     * 修改附件信息
     * @return
     */
    @RequestMapping(value = "/extCproductAction_updates",method = RequestMethod.PUT)
    public String updates(ExtCproduct extCproduct,RedirectAttributes redirectAttributes){
        extCproductService.update(extCproduct);

        //重定向携带contractProductId参数
        redirectAttributes.addAttribute("contractProductId",extCproduct.getContractProductId());

        //存放contractId数据
        redirectAttributes.addAttribute("contractId",extCproduct.getContractProduct().getContract().getContractId());
        return "redirect:/cargo/extCproduct_tocreates";
    }

    /**
     * 删除附件
     * @return
     */
    @RequestMapping("/extCproductAction_deletes")
    public String deletes(ExtCproduct extCproduct,RedirectAttributes redirectAttributes){
        extCproductService.delete(extCproduct);

        //重定向携带contractProductId参数
        redirectAttributes.addAttribute("contractProductId",extCproduct.getContractProductId());

        //存放contractId数据
        redirectAttributes.addAttribute("contractId",extCproduct.getContractProduct().getContract().getContractId());
        return "redirect:/cargo/extCproduct_tocreates";
    }
}
