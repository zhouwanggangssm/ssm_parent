package cn.xt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String logins(){
        return "home/fmain";
    }
}
