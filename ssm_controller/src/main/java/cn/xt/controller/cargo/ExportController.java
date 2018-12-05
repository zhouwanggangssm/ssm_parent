package cn.xt.controller.cargo;

import cn.xt.domain.Contract;
import cn.xt.domain.Export;
import cn.xt.service.ContractService;
import cn.xt.service.ExportService;
import cn.xt.utils.SysConstant;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 报运
 */
@Controller
@RequestMapping("/cargo")
public class ExportController {
    @Autowired
    private ContractService contractService;
    @Autowired
    private ExportService exportService;
    /**
     * 分页，查询报运单
     * @return
     */
    @RequestMapping("/export_List")
    public String list(@RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex,
                       Model model){
        //分页插件
        PageHelper.startPage(pageIndex, SysConstant.PAGE_SIZE);
        //状态为1
        List<Export> list = exportService.findList();
        PageInfo pageInfo = new PageInfo(list);
        model.addAttribute("results",pageInfo.getList());
        model.addAttribute("totalPageCount",pageInfo.getPages());//总页数
        model.addAttribute("totalCount",pageInfo.getTotal()); //总记录数
        model.addAttribute("currentPageNo",pageIndex);//当前页
        return "cargo/export/jExportList";
    }

    @RequestMapping("/export_contractlist")
    public String seleteContract(@RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex,
                                 Model model){
        //分页插件
        PageHelper.startPage(pageIndex,SysConstant.PAGE_SIZE);
        //查询购销合同
        List<Contract> contractList = exportService.getContractInfo();
        PageInfo pageInfo = new PageInfo(contractList);
        model.addAttribute("results",pageInfo.getList());
        model.addAttribute("totalPageCount",pageInfo.getPages());//总页数
        model.addAttribute("totalCount",pageInfo.getTotal()); //总记录数
        model.addAttribute("currentPageNo",pageIndex);//当前页
        return "cargo/export/jContractList";
    }

    /**
     * 查看购销合同
     * @return
     */
    @RequestMapping("/contract_toviews")
    public String view(@RequestParam("contractId") String contractId,Model model){
        Contract contract = contractService.getIdInfo(contractId);
        model.addAttribute("contract",contract);
        return "cargo/contract/jContractView";
    }

    /**
     * 报运新增页面
     * @return
     */
    @RequestMapping("/export_tocreate")
    public String ExportUI(@RequestParam("contractId") String contractId,
    Model model){
        model.addAttribute("contractId",contractId);
        return "cargo/export/jExportCreate";
    }

    /**
     * 添加报运
     * @return
     */
    @RequestMapping(value = "/export_insert",method = RequestMethod.POST)
    public String ExportAdd(Export export,@RequestParam("contractIds") String[] ids){
        //调用业务层的方法
        exportService.add(export,ids);
        return "redirect:/cargo/export_List";
    }

    /**
     * 报运修改页面
     * @return
     */
    @RequestMapping("/export_toupdate")
    public String toUpdate(String exportId,Model model){
        //报运单回显数据
        Export export = exportService.get(exportId);
        model.addAttribute("export",export);

        //准备批量修改控件的数据
        String mrecordData = exportService.getMrecordData(exportId);
        model.addAttribute("mRecordData",mrecordData);
        return "cargo/export/jExportUpdate";
    }

    /**
     * 修改
     * @param export
     * @return
     */
    @RequestMapping(value = "/export_update",method = RequestMethod.PUT)
    public String updates(Export export,
                          String[] mr_id,
                          Integer[] mr_orderNo,
                          Integer[] mr_cnumber,
                          Double[] mr_grossWeight,
                          Double[] mr_netWeight,
                          Double[] mr_sizeLength,
                          Double[] mr_sizeWidth,
                          Double[] mr_sizeHeight,
                          Double[] mr_exPrice,
                          Double[] mr_tax){
        //修改报运单加批量修改货物
        exportService.upadte(export, mr_id, mr_orderNo, mr_cnumber, mr_grossWeight, mr_netWeight, mr_sizeLength, mr_sizeWidth, mr_sizeHeight, mr_exPrice, mr_tax);
        return "redirect:/cargo/export_List";
    }

    /**
     * 查看
     * @return
     */
    @RequestMapping("/export_toview")
    public String toView(String exportId,Model model){
        Export export = exportService.get(exportId);
        model.addAttribute("export",export);
        return "cargo/export/jExportView";
    }

    /**
     * 删除，级联删除
     * @return
     */
    @RequestMapping(value = "/export_delete",method = RequestMethod.DELETE)
    public String deletes(String exportId){
        //接收id,分割
        exportService.delete(exportId.split(","));
        return "redirect:/cargo/export_List";
    }

    /**
     * 提交
     * @return
     */
    @RequestMapping("/export_submit")
    public String submit(String exportId){
        String[] ids = exportId.split(",");
        this.changeState(1,ids);
        return "redirect:/cargo/export_List";
    }

    /**
     * 取消
     * @return
     */
    @RequestMapping("/export_cancel")
    public String cancel(String exportId){
        String[] ids = exportId.split(",");
        this.changeState(0,ids);
        return "redirect:/cargo/export_List";
    }

    /**
     * 改变状态
     */
    private void changeState(Integer state,String[] ids){
        Map<String,Object> map = new HashMap<>();
        map.put("state",state);
        map.put("ids",ids);
        exportService.updateState(map);
    }
}














