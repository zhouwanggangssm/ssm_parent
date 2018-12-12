package cn.xt.controller.cargo;

import cn.xt.domain.PackingList;
import cn.xt.service.PackingListService;
import cn.xt.utils.SysConstant;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 装箱
 */
@Controller
@RequestMapping("/cargo")
public class PackingListController {
    @Autowired
    private PackingListService packingListService;

    /**
     * 查询所有，分页
     * @return
     */
    @RequestMapping("/packinglist_packing_list")
    public String list(@RequestParam(value = "pageIndex",required = false,defaultValue = "1") int pageIndex, Model model){
        //分页PageHelper
        PageHelper.startPage(pageIndex, SysConstant.PAGE_SIZE);
        //查询所有装箱信息
        List<PackingList> list = packingListService.findPage();
        PageInfo pageInfo = new PageInfo(list);
        model.addAttribute("results",pageInfo.getList());//数据
        model.addAttribute("totalPageCount",pageInfo.getPages());//总页数
        model.addAttribute("totalCount",pageInfo.getTotal()); //总记录数
        model.addAttribute("currentPageNo",pageIndex);//当前页
        return "cargo/packinglist/jPackingListListPage";
    }

    /**
     * 新增页面
     * @return
     */
    @RequestMapping("/packinglist_tocreate")
    public String toCreate(String[] exportId,Model model){//出口报运ID集合
        //携带出口报运的id集合，显示装箱和报运的关系
        //调用getDivDataCreate
        model.addAttribute("divData",packingListService.getDivDataCreate(exportId));
        return "cargo/packinglist/jPackingListCreate";
    }

    /**
     * 新增装箱保存
     * @return
     */
    @RequestMapping(value = "/packingListAction_insert",method = RequestMethod.POST)
    public String inserts(PackingList packingList){
        //新增
        packingListService.insert(packingList);
        return "redirect:/cargo/packinglist_packing_list";
    }

    /**
     * 修改页面，回显
     * @return
     */
    @RequestMapping("/packingList_toupdate")
    public String updateUI(String packingListId,Model model){
        //查询装箱信息
        PackingList packingList = packingListService.get(packingListId);
        model.addAttribute("packingList",packingList);

        //调用getDivDataUpdate
        //getExportIds ， getExportNos用 |分割
        String divDataUpdate = packingListService.getDivDataUpdate(packingList.getExportIds().split("\\|"), packingList.getExportNos().split("\\|"));
        model.addAttribute("divData",divDataUpdate);
        return "cargo/packinglist/jPackingListUpdate";
    }

    /**
     * 修改装箱
     * @return
     */
    @RequestMapping(value = "/packingList_update",method = RequestMethod.PUT)
    public String updates(PackingList packingList){
        //修改
        packingListService.update(packingList);
        return "redirect:/cargo/packinglist_packing_list";
    }

    /**
     * 查看
     * @return
     */
    @RequestMapping("/packingList_toview")
    public String toView(String packingListId,Model model){
        //查看
        PackingList packingList = packingListService.get(packingListId);
        model.addAttribute("packingList",packingList);

        //调用拼串方法getDivDataView 合同号getExportNos 用| 分割
        model.addAttribute("divData",packingListService.getDivDataView(packingList.getExportNos().split("\\|")));
        return "cargo/packinglist/jPackingListView";
    }

    /**
     * 删除
     * @return
     */
    @RequestMapping(value = "/packingList_delete",method = RequestMethod.DELETE)
    public String deletes(String packingListId){
        //删除成功
        packingListService.delete(packingListId);
        return "redirect:/cargo/packinglist_packing_list";
    }

    /**
     * 提交，修改状态为1
     * @return
     */
    @RequestMapping("/packingList_submit")
    public String submit(String packingListId){
        //提交  用逗号分割
        this.ChangeState(1,packingListId.split(","));
        return "redirect:/cargo/packinglist_packing_list";
    }

    /**
     * 取消，修改状态为0
     * @return
     */
    @RequestMapping("/packingList_cancel")
    public String cancel(String packingListId){
        //取消
        this.ChangeState(0,packingListId.split(","));
        return "redirect:/cargo/packinglist_packing_list";
    }

    /**
     * 改变状态
     * @param state
     * @param packingListId
     */
    private void ChangeState(Integer state,String[] packingListId){
        //创建map对象
        Map<String,Object> map = new HashMap<>();
        map.put("state",state);
        map.put("ids",packingListId);
        packingListService.updateState(map);
    }
}
