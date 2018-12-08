package cn.xt.controller;

import cn.xt.domain.User;
import cn.xt.service.UserService;
import cn.xt.utils.SysConstant;
import cn.xt.utils.UtilFuns;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;


    //进入登录页面
    @RequestMapping("/login")
    public String login(){
        return "sysadmin/login/login";
    }


    //登录
    @RequestMapping(value = "/dologin")
    public String dologin(@RequestParam(value = "username",required = false) String username,
                          @RequestParam(value = "password",required = false) String password,
                          HttpServletRequest request, HttpSession session){
//        try {
//          //查询用户名
//          User userExist=userService.UserExist(username);
//          //判断用户名是否不等于空
//          if(userExist!=null) {
//              //密码加密
//              String pwd=MD5.MD5(password);
//              //用户登录
//              User user = userService.Userlogin(username, pwd);
//              //判断用户是否不等于空
//              if (user != null) {
//                  //登录成功   把user存进session作用域
//                  session.setAttribute(SysConstant.CURRENT_USER_INFO, user);
//                  return "home/fmain";
//              } else {
//                  //登录失败  提示密码错误
//                  request.setAttribute("loginFailed", 1);
//                  return "index";
//              }
//          }else {
//              //用户名等于空  提示用户名不存在
//              request.setAttribute("loginFailed", 2);
//              return "index";
//          }
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        if(UtilFuns.isEmpty(username)){
            return "redirect:/login";
        }

        try {
            //1.得到Subject
            Subject subject= SecurityUtils.getSubject();
            //2.调用登录方法
            UsernamePasswordToken token=new UsernamePasswordToken(username,password);
            subject.login(token);//当这一行代码执行时，就会自动跳入到AuthRealm中认证方法

            //3.登录成功时，就从Shiro中取出用户的登录信息
            User user= (User) subject.getPrincipal();

            //4.将用户放入session域中
            session.setAttribute(SysConstant.CURRENT_USER_INFO,user);
            
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("errorInfo","对不起，用户名或密码错误！");
            return "redirect:/login";
        }
        // 登录成功跳转到主页
        return "home/fmain";    }


    //注销
    @RequestMapping("/logout")
    public void logout(){
        //shiro注销，shiro会自动把session释放，所以不需要调用session.invalidate();方法
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
    }

}
