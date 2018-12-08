package cn.xt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @RequestMapping("/homeAction_title")
    public String title(){
        return "home/title";
    }

    @RequestMapping("/homeAction_fmain")
    public String fmain(){
        return "home/fmain";
    }

    @RequestMapping("/homeAction_toleft.html")
    public String left(@RequestParam("moduleName") String moduleName){
        if(moduleName.equals("sysadmin")){
            return "sysadmin/left";
        }else if(moduleName.equals("cargo")){
            return "cargo/left";
        }else if(moduleName.equals("baseinfo")){//
            return "baseinfo/left";
        }else if(moduleName.equals("stat")){
            return "stat/left";
        }
        return "home/left";
    }

    @RequestMapping("/homeAction_tomain.html")
    public String main(@RequestParam("moduleName") String moduleName){
        if(moduleName.equals("sysadmin")){
            return "sysadmin/main";
        }else if(moduleName.equals("cargo")){
            return "cargo/main";
        }else if(moduleName.equals("baseinfo")){
            return "baseinfo/main";
        }else if(moduleName.equals("stat")){
            return "stat/main";
        }

        return "home/main";
    }
}
