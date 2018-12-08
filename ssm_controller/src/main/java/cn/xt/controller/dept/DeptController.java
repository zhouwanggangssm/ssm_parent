package cn.xt.controller.dept;

import cn.xt.domain.Dept;
import cn.xt.domain.User;
import cn.xt.service.DeptService;
import cn.xt.service.UserService;
import cn.xt.utils.PageSupport;
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

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    DeptService deptService;
    @Autowired
    UserService userService;


    @RequestMapping("/dept_list")
    public String list(@RequestParam(value = "pageIndex",required = false,defaultValue = "1") int pageIndex, Model model){
//        //当前页非空验证
//        int currentPageNo=1;
//        if(pageIndex!=null){
//            currentPageNo=Integer.parseInt(pageIndex);
//        }
//        try {
//            //设置页面大小
//            int pageSize = SysConstant.PAGE_SIZE;
//            //部门表总记录数
//            int totalCount = deptService.getDeptCount();
//
//            //构建分页对象
//            PageSupport pageSupport=new PageSupport();
//            pageSupport.setCurrentPageNo(currentPageNo);
//            pageSupport.setPageSize(pageSize);
//            pageSupport.setTotalCount(totalCount);
//            //页面总数
//            int totalPageCount=pageSupport.getTotalPageCount();
//
//
//            //查询部门信息
//           List<Dept> deptList=deptService.findPage(((currentPageNo-1)*pageSize),pageSize);
//            //传递部门信息
//            model.addAttribute("deptList", deptList);
//            //传递页面大小
//            model.addAttribute("pageSize",pageSize);//页面大小
//            //传递总页数
//            model.addAttribute("totalPageCount",totalPageCount);//总页数
//            //传递总行数
//            model.addAttribute("totalCount",totalCount);//总行数
//            //传递当前页
//            model.addAttribute("currentPageNo",currentPageNo);//当前页
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        try {


            //使用分页的插件 pageHelper
            PageHelper.startPage(pageIndex, SysConstant.PAGE_SIZE);
            //传入当前页，每页显示5条
            List<Dept> deptList = deptService.findPage();
            //把查出来的数据放进pageInfo
            PageInfo pageInfo = new PageInfo(deptList);


            //传递部门信息
            model.addAttribute("deptList", pageInfo.getList());
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
        return  "sysadmin/dept/jDeptList";
    }

    //查看部门信息
    @RequestMapping(value = "/toview")
    public String getDeptById(@RequestParam String id, Model model){
        try {
            //按id查询部门对象
            Dept dept= deptService.getDeptById(id);
            //将dept放进model
            model.addAttribute("dept",dept);
        }catch (Exception e){
            e.printStackTrace();
        }

         return "sysadmin/dept/jDeptView";
    }

    //准备添加页面数据
    @RequestMapping("/tocreate")
    public String tocreateData(Model model){
        try {
            //查询所有部门对象
            List<Dept> deptList=deptService.getUpDept();
            //将deptList放进model
            model.addAttribute("deptList",deptList);
        }catch (Exception e){
            e.printStackTrace();
        }

        return "sysadmin/dept/jDeptCreate";
    }

    //添加部门
    @RequestMapping("/adddept")
    public String addDept(Dept dept){
        //随机产生部门id
        String deptId= StringUtils.randomUUID();


        //将部门id放进部门对象
        dept.setDeptId(deptId);
        //将部门状态信息放进部门对象 部门状态 0 停用 1 启用
        dept.setState(1);


        try {
            //判断添加部门是否成功
            if(deptService.addDept(dept)>0){
                //重定向到dept_list
                return "redirect:/dept/dept_list";
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return "sysadmin/dept/jDeptCreate";
    }

    //准备修改页面的数据
    @RequestMapping("/updateUI")
    public String DeptUpdateUI(@RequestParam("id") String id, Model model){
        try {
           //查询所有部门
           List<Dept> deptList=deptService.getUpDept();
           //按id查询部门
           Dept dept = deptService.getDeptById(id);


            //将deptList放进model
            model.addAttribute("deptList",deptList);
            //将dept放进model
            model.addAttribute("dept",dept);

        }catch (Exception e){
            e.printStackTrace();
        }
        return "sysadmin/dept/jDeptUpdate";
    }


    //修改部门信息
    @RequestMapping("/updateDept")
    public String updateDept(Dept dept){



        //判断本部门id是否等于上级部门id
        if(dept.getDeptId().equals(dept.getParentId().getDeptId())){
            //传入空值到上级部门
            dept.setParentId(null);
        }
        try {
            //判断是否修改成功
            if(deptService.updateDept(dept)>0){
                //重定向到dept_list
                return "redirect:/dept/dept_list";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "sysadmin/dept/jDeptUpdate";
    }

    //删除部门
    @RequestMapping(value = "/deleteDept",method = RequestMethod.POST)
    public String deleteDept(@RequestParam("id") String id){
        try {

            //创建String类型list集合
            List<String> list = new ArrayList<>();
            //判断id是否为，分割
            if (id.contains(",")) {
                //把id放进String数组中，然后split分割
                String[] idlist = id.split(",");
                //组装id的集合
                for (String i : idlist) {
                    list.add(i);
                }

                //批量清空用户的部门id
                deptService.updateUserDeptId(id);

                //批量删除部门
                if (deptService.deleteDeptList(list) > 0) {
                    return "redirect:/dept/dept_list";
                }


            } else {
                //单个清空用户的部门id
                deptService.updateUserDeptId(id);

                //单个删除部门
                if (deptService.deleteDept(id) > 0) {
                    return "redirect:/dept/dept_list";
                }


            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:/dept/dept_list";
    }
}
