package cn.xt.controller.sysadmin;

import cn.xt.domain.Dept;
import cn.xt.service.DeptService;
import cn.xt.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sysadmin")
public class DeptController {
    @Autowired
    DeptService deptService;

    @RequestMapping("/dept_list")
    public String list(Map<String,Object>map){
      /*  List<Dept> deptByPage = deptService.findDeptByPage();
        map.put("depts",deptByPage);*/
        return  "sysadmin/dept/jDeptList";
    }
}
