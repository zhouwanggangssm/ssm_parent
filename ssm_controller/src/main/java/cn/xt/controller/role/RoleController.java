package cn.xt.controller.role;
import cn.xt.domain.Module;
import cn.xt.domain.Role;
import cn.xt.domain.RoleModule;
import cn.xt.domain.User;
import cn.xt.service.ModuleService;
import cn.xt.service.RoleService;
import cn.xt.utils.StringUtils;
import cn.xt.utils.SysConstant;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.*;


@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private ModuleService moduleService;


    //分页查询所有角色
    @RequestMapping("/role_list")
    public String RolePage(@RequestParam(value = "pageIndex",required = false,defaultValue = "1") int pageIndex, Model model){
        try {
            //使用分页的插件 pageHelper  传入当前页，每页显示5条
            PageHelper.startPage(pageIndex,SysConstant.PAGE_SIZE);
            //查询角色分页
            List<Role> roleList=roleService.findRolePage();
            //把查出来的数据放进pageInfo
            PageInfo pageInfo=new PageInfo(roleList);

            //传递角色信息
            model.addAttribute("roleList",pageInfo.getList());
            //传递当前页
            model.addAttribute("currentPageNo",pageIndex);
            //传递页面大小
            model.addAttribute("pageSize",SysConstant.PAGE_SIZE);
            //传递总页数
            model.addAttribute("totalPageCount",pageInfo.getPages());
            //传递总条数
            model.addAttribute("totalCount",pageInfo.getTotal());
        }catch (Exception e){
            e.printStackTrace();
        }


        return "sysadmin/role/jRoleList";
    }

    //按id查询角色
    @RequestMapping("/findRoleById")
    public String findRoleById(@RequestParam(value = "id",required = false) String id,Model model){
        try {
            Role role=roleService.findRoleById(id);
            model.addAttribute("role",role);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "/sysadmin/role/jRoleView";
    }

    //进入添加页面
    @RequestMapping("/addRoleUI")
    public String addRoleUI(){
        return "/sysadmin/role/jRoleCreate";
    }

    //添加角色
    @RequestMapping("/addRole")
    public String addRole(Role role, HttpSession session){
        try {
            //随机产生id
            String id= StringUtils.randomUUID();
            //添加到role对象
            role.setRoleId(id);

            //创建时间
            role.setCreateTime(new Date());
            //创建人id
            role.setCreateBy(((User)session.getAttribute(SysConstant.CURRENT_USER_INFO)).getUserId());
            //创建人部门
            role.setCreateDept(((User) session.getAttribute(SysConstant.CURRENT_USER_INFO)).getDept().getDeptName());


            //排序号
            role.setOrderNo(+1);

            //修改时间
            role.setUpdateTime(new Date());
            if(roleService.addRole(role)>0){
                return "redirect:/role/role_list";
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return "/sysadmin/role/jRoleCreate";
    }


    //准备修改角色页面的信息
    @RequestMapping("/updateRoleUI")
    public String updateRoleUI(@RequestParam(value = "id",required = false) String id,Model model){
        try {
            //按id查询角色
            Role role=roleService.findRoleById(id);
            //传递role对象到修改页面
            model.addAttribute("role",role);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "/sysadmin/role/jRoleUpdate";
    }


    //修改角色
    @RequestMapping("/updateRole")
    public String updateRole(Role role,HttpSession session){
        try {
            //修改人id
            role.setUpdateBy(((User)session.getAttribute(SysConstant.CURRENT_USER_INFO)).getUserId());
            //修改时间
            role.setUpdateTime(new Date());

            if(roleService.updateRole(role)>0){
                return "redirect:/role/role_list";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "/sysadmin/role/jRoleUpdate";
    }


    //删除角色
    @RequestMapping("/deleteRole")
    public String deleteRole(@RequestParam(value = "id") String id){
        try {
            //创建String类型list集合
            List<String> list=new ArrayList<>();
            //判断id是否为，分割
            if(id.contains(",")){
                //把id放进String数组中，然后split分割
                String [] idlist=id.split(",");
                //组装id的集合
                for(String i:idlist){
                    list.add(i);
                }
                //批量删除roleuser表下的相关信息
                roleService.deleteRoleUserroleIdList(list);
                //批量删除rolemodule表下的相关信息
                roleService.deleteRoleModuleroleIdList(list);
                if(roleService.deleteRoleList(list)>0){
                    return "redirect:/role/role_list";
                }
            }else {
                //删除role_user_p表中相关的信息
                roleService.deleteRoleUserroleId(id);
                //删除role_module_p表中相关的信息
                roleService.deleteRoleModuleroleId(id);
                    //删除主表里的角色
                    if (roleService.deleteRole(id) > 0) {
                        return "redirect:/role/role_list";
                    }
                }


        }catch (Exception e){
            e.printStackTrace();
        }

        return "";
    }


    //进入角色模板页面
    @RequestMapping("/rolemoduleUI")
    public String rolemoduleUI(@RequestParam(value = "id",required = false) String id,Model model){
        try {
            Role role=roleService.findRoleById(id);
            model.addAttribute("role",role);
            List<Module> moduleList=moduleService.findModule();
            model.addAttribute("moduleList",moduleList);
        }catch (Exception e){
            e.printStackTrace();
        }

        return "sysadmin/role/jRoleModule";
    }


//    //准备zTree树
//    @RequestMapping("/roleModuleJsonStr")
//    @ResponseBody
//    public Object roleModuleJsonStr(@RequestParam(value = "id",required = false) String id,Model model,HttpServletResponse response){
//        try {
//            //1.根据角色id，得到角色对象
//            Role role=roleService.findRoleById(id);
//
//            //2.通过对象导航方式，加载出当前角色的模块列表
//            Set<Module> moduleSet=role.getModules();
//
//            //3.加载出所有的模块列表
//            List<Module> ModuleList=moduleService.findModule();
//            int size=ModuleList.size();
//            //4.组织json串
//            StringBuilder sb=new StringBuilder();
//            sb.append("[");
//            for(Module module:ModuleList){
//
//
//                size--;
//                sb.append("{\"moduleId\":\"").append(module.getModuleId());
//                sb.append("\",\"parentId\":\"").append(module.getParentId());
//                sb.append("\",\"name\":\"").append(module.getName());
//                sb.append("\",\"checked\":\"");
//                if(moduleSet.contains(module)){
//                    sb.append("true");
//                }else {
//                    sb.append("false");
//                }
//                sb.append("\"}");
//            }
//
//            //5.得到response对象
//            response.setContentType("application/json;charset=UTF-8");
//            response.setHeader("Cache-Control","no-cache");
//
//            //6.使用response对象输出json串
//            response.getWriter().write(sb.toString());
//
//
//            return "/sysadmin/role/jRoleModule";
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }

    //给角色添加权限模板
    @RequestMapping(value = "/addRoleModule",method = RequestMethod.POST)
    public String addRoleModule(RoleModule roleModule){
        try {
            //给角色添加多个模块
            if(roleService.addRoleModule(roleModule)>0){
                return "redirect:/role/role_list";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "/sysadmin/role/jRoleModule";
    }
}
