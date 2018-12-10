package cn.xt.controller.user;

import cn.xt.domain.*;
import cn.xt.service.DeptService;
import cn.xt.service.RoleService;
import cn.xt.service.RoleuserService;
import cn.xt.service.UserService;
import cn.xt.utils.MD5;
import cn.xt.utils.PageSupport;
import cn.xt.utils.StringUtils;
import cn.xt.utils.SysConstant;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    DeptService deptService;
    @Autowired
    RoleService roleService;
    @Autowired
    RoleuserService roleuserService;


    @RequestMapping("/user_list")
    public String findUserPage(@RequestParam(value = "pageIndex",required = false) String pageIndex, Model model){
        //当前页非空验证
        int currentPageNo=1;
        if(pageIndex!=null){
            currentPageNo=Integer.parseInt(pageIndex);
        }
        try {
            //设置页面大小
            int pageSize = SysConstant.PAGE_SIZE;
            //用户表的总记录数
            int totalCount = userService.getUserCount();

            //构建分页对象
            PageSupport pageSupport=new PageSupport();
            //当前页
            pageSupport.setCurrentPageNo(currentPageNo);
            //页面大小
            pageSupport.setPageSize(pageSize);
            //总条数
            pageSupport.setTotalCount(totalCount);
            //页面总数
            int totalPageCount=pageSupport.getTotalPageCount();

            //查询用户信息
            List<User> userList=userService.findUserPage(((currentPageNo-1)*pageSize),pageSize);
            //用户信息
            model.addAttribute("userList",userList);
            //当前页
            model.addAttribute("currentPageNo",currentPageNo);
            //总条数
            model.addAttribute("totalCount",totalCount);
            //页面总数
            model.addAttribute("totalPageCount",totalPageCount);
            //页面大小
            model.addAttribute("pageSize",pageSize);

        }catch (Exception e){
            e.printStackTrace();
        }

        return "/sysadmin/user/jUserList";
    }


    //查看单个用户
    @RequestMapping("/findByIdUser")
    public String findByIdUser(@RequestParam(value = "id",required = false) String id, Model model) {
        try {
            //查询单个用户
            User user = userService.getUserById(id);
            //将user对象放进model
            model.addAttribute("user", user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/sysadmin/user/jUserView";
    }


    //准备添加用户页面的数据
    @RequestMapping("/getUpUserUI")
    public String getUpUserUI(Model model){
        try {
            //查询所有部门
            List<Dept> deptList=deptService.getUpDept();
            //将deptList对象放进model
            model.addAttribute("deptList",deptList);
            //查询所有直属领导
            List<UserInfo> userList=userService.getUpmanager();
            //将userList对象放进model
            model.addAttribute("userList",userList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "/sysadmin/user/jUserCreate";
    }

    //添加用户提交事务更新数据库
    @Transactional
    protected int addUser(User user) throws Exception {
        //添加用户
        int adduser=userService.addUser(user);
        return adduser;
    }
    //添加用户表及用户扩展表的信息
    @RequestMapping("/addUserOraddUserInfo")
    public String addUserOraddUserInfo(User user, UserInfo userInfo,HttpSession session){
        try {
            //添加时产生的id
            String id = StringUtils.randomUUID();
            //赋值到user对象
            user.setUserId(id);
            //赋值到userinfo对象
            userInfo.setUserInfoId(id);

            //默认密码12345 Md5Hash进行加密
            String password= new Md5Hash("12345",user.getUserName(),2).toString();
            //赋值到user对象
            user.setPassword(password);

            //创建人id
            user.setCreateBy(((User)session.getAttribute(SysConstant.CURRENT_USER_INFO)).getUserId());
            userInfo.setCreateBy(((User)session.getAttribute(SysConstant.CURRENT_USER_INFO)).getUserId());
            //创建人部门
            user.setCreateDept(((User) session.getAttribute(SysConstant.CURRENT_USER_INFO)).getDept().getDeptName());
            userInfo.setCreateDept(((User) session.getAttribute(SysConstant.CURRENT_USER_INFO)).getDept().getDeptName());

            //创建时间
            user.setCreateTime(new Date());
            userInfo.setCreateTime(new Date());

            //添加用户和添加用户扩展信息
            if (addUser(user)>0&&userService.addUserInfo(userInfo)>0){
                return "redirect:/user/user_list";
            }

        }catch (Exception e){
            e.printStackTrace();
        }
          return "/sysadmin/user/jUserCreate";
    }


    //删除单个用户
    @RequestMapping(value = "/deleteUser",method= RequestMethod.POST)
    public String deleteUser(@RequestParam("id") String id){
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
            //批量删除
            try {

                     //批量删除用户扩展表和用户角色表
                     userService.deleteUserInfoList(list);
                     //批量删除用户角色表
                     userService.deleteUserRoleByIdList(list);

                         //批量删除用户表
                         if(userService.deleteUserList(list)>0){
                         return "redirect:/user/user_list";
                     }

            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            //单个删除
            try {

                     //单个删除用户角色表的关联角色
                     userService.deleteUserRoleById(id);
                     //单个删除用户表扩展表
                     userService.deleteUserInfoById(id);


                        //单个删除用户表
                        if(userService.deleteUser(id)>0){
                        return "redirect:/user/user_list";
                  }

            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return "";
    }


    //准备修改页面的数据
    @RequestMapping("/getUpdateUI")
    public String getUpdateUI(@RequestParam("id") String id, Model model){
       try {
           //查询所有部门信息
           List<Dept> deptList=deptService.getUpDept();
           //将deptList放进model
           model.addAttribute("deptList",deptList);
           //按id查询用户
           User user=userService.getUserById(id);
           //将user放进model
           model.addAttribute("user",user);
       }catch (Exception e){
           e.printStackTrace();
       }
       return "/sysadmin/user/jUserUpdate";
    }


    //修改用户信息
    @RequestMapping("/updateUser")
    public String updateUser(User user,HttpSession session){
        try {
            //修改人id
            user.setUpdateBy(((User)session.getAttribute(SysConstant.CURRENT_USER_INFO)).getUserId());

            //修改时间
            user.setUpdateTime(new Date());


            //修改用户
            if(userService.updateUser(user)>0){
                return "redirect:/user/user_list";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "/sysadmin/user/jUserUpdate";
    }

    //准备添加角色页面的信息
    @RequestMapping("/UserRoleUI")
    public String UserRoleUI(@RequestParam String id, Model model){
        try {
            //单个查询用户扩展信息
            UserInfo userInfo=userService.findByIdUserInfo(id);
            //将userInfo对象放进model
            model.addAttribute("userInfo",userInfo);
            //查询所有角色
            List<Role> roleList=roleService.findRoleList();
            //将roleList集合放进model
            model.addAttribute("roleList",roleList);

        }catch (Exception e){
            e.printStackTrace();
        }

        return "/sysadmin/user/jUserRole";
    }

    //给用户添加角色
    @RequestMapping(value = "/saveUserRole",method = RequestMethod.POST)
    public String saveUserRole(RoleUser roleUser){
         try {

             //给用户添加一个或者多个角色
             if(userService.addRoleUser(roleUser)>0){
                 return "redirect:/user/user_list";
             }

         }catch (Exception e){
             e.printStackTrace();
         }

        return "/sysadmin/user/jUserRole";
    }



    }


