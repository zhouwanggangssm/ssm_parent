package cn.xt.controller.module;

import cn.xt.domain.Module;
import cn.xt.domain.User;
import cn.xt.service.ModuleService;
import cn.xt.utils.StringUtils;
import cn.xt.utils.SysConstant;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jms.Session;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/module")
public class ModuleController {
    @Autowired
    private ModuleService moduleService;

    @RequestMapping("/module_list")
    public String findModuleList(@RequestParam(value = "pageIndex",required = false,defaultValue = "1") int pageIndex, Model model){
        try{
            //使用分页的插件 pageHelper
            PageHelper.startPage(pageIndex, SysConstant.PAGE_SIZE);
            //传入当前页，每页显示5条
            List<Module> moduleList =moduleService.findModule();
            //把查出来的数据放进pageInfo
            PageInfo pageInfo = new PageInfo(moduleList);

            //传递部门信息
            model.addAttribute("moduleList", pageInfo.getList());
            //传递页面大小
            model.addAttribute("pageSize",SysConstant.PAGE_SIZE);//页面大小
            //传递总页数
            model.addAttribute("totalPageCount",pageInfo.getPages());//总页数
            //传递总行数
            model.addAttribute("totalCount",pageInfo.getTotal());//总行数
            //传递当前页
            model.addAttribute("currentPageNo",pageIndex);//当前页
        }catch (Exception e){
            e.printStackTrace();
        }
        return "sysadmin/module/jModuleList";
    }

    //查看单个模板
    @RequestMapping("/findmodulebyid")
    public String findModuleById(@RequestParam("id") String id,Model model){
        try {
            //查询单个模板
            Module module=moduleService.findModuleById(id);
            //将module放进model
            model.addAttribute("module",module);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "sysadmin/module/jModuleView";
    }

    //进入添加模板页面
    @RequestMapping("/addmoduleUI")
    public String addmoduleUI(){

        return "sysadmin/module/jModuleCreate";
    }


    //添加模板
    @RequestMapping("/addmodule")
    public String addModule(Module module, HttpSession session){
        try {
            //生成moduleId
            String moduleId= StringUtils.randomUUID();
            //将moduleId放进module对象
            module.setModuleId(moduleId);
            //创建人id((User)session.getAttribute(Constants.USER_SESSION)).getId()
            module.setCreateBy(((User)session.getAttribute(SysConstant.CURRENT_USER_INFO)).getUserId());
            //创建人部门
            module.setCreateDept(((User)session.getAttribute(SysConstant.CURRENT_USER_INFO)).getDept().getDeptName());
            //创建时间
            module.setCreateTime(new Date());

            //添加模板
            if(moduleService.addModule(module)>0){
                return "redirect:/module/module_list";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "sysadmin/module/jModuleCreate";
    }

    //进入修改模板页面
    @RequestMapping("/updateModuleUI")
    public String updateModuleUI(@RequestParam("id") String id,Model model){
        try {
            //查询单个模板
            Module module=moduleService.findModuleById(id);
            //将module对象放进model
            model.addAttribute("module",module);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "sysadmin/module/jModuleUpdate";
    }


    //修改模板
    @RequestMapping("/updateModule")
    public String updateModule(Module module,HttpSession session){
        try {
            //修改人id
            module.setUpdateBy(((User)session.getAttribute(SysConstant.CURRENT_USER_INFO)).getUserId());
            //修改时间
            module.setUpdateTime(new Date());

            //修改模板
          if(moduleService.updateModule(module)>0){
                return "redirect:/module/module_list";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "sysadmin/module/jModuleUpdate";
    }

    //删除模板
    @RequestMapping("/deleteModule")
    public String deleteModule(@RequestParam("id") String id){
        try {
           //创建String类型List集合
            List<String> list=new ArrayList<>();
            //判断id是否为，分割
            if(id.contains(",")){
                //把id放进String数组中，然后split分割
                String [] idlist=id.split(",");
                //组装id的集合
                for(String i:idlist){
                    list.add(i);
                }

                //批量删除rolemodule表的关联信息
                moduleService.deleteRoleModuleList(list);
                //批量删除module表的信息
                if(moduleService.deleteModuleList(list)>0){
                    return "redirect:/module/module_list";
                }
            }else {
                //单个删除rolemodule表的关联信息
                moduleService.deleteRoleModuleId(id);
                //单个删除module表的信息
                if(moduleService.deleteModule(id)>0){
                    return "redirect:/module/module_list";
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
}
