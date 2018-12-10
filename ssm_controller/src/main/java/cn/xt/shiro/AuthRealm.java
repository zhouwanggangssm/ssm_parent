package cn.xt.shiro;

import cn.xt.domain.Module;
import cn.xt.domain.Role;
import cn.xt.domain.User;
import cn.xt.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    //授权   当jsp页面出现Shiro标签时，就会执行授权方法
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
        User user= (User) pc.fromRealm(this.getName()).iterator().next();//根据realm的名字区找对应的realm
        //创建SimpleAuthorizationInfo对象
        SimpleAuthorizationInfo info=null;
        try {

            //Set<Role> roles=user.getRoles();//对象导航
            List<Role> roles=userService.findUserRoleusername(user.getUserName());
            if(null==roles||0==roles.size()){
                return null;
            }{
                //info对象
                info=new SimpleAuthorizationInfo();
                //遍历每个角色
                for(Role role:roles){
                    System.out.println("用户拥有的角色======================================="+role.getName());
                    info.addRole(role.getName());//添加用户的角色（权限）
                    //得到每个角色下的模块列表
                    List<Module> modules=userService.findRoleModulerolename(role.getName());
                    for(Module m:modules){
                        System.out.println("角色拥有的模块======================================="+m.getName());
                        info.addStringPermission(m.getName());//添加用户的模块（权限）
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return info;
    }

    //认证  token代表用户再界面输入的用户名和密码  info代表从数据库中得到加密数据
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //1.向下转型
        UsernamePasswordToken upToken= (UsernamePasswordToken) token;

        //2.调用业务层方法，实现根据用户名查询
        try {
            //查询用户名
            List<User> list=userService.UserExist(upToken.getUsername());
            //判断list不为空并且size>0
            if(list!=null&&list.size()>0){
                //得到list第一个用户
                User user=list.get(0);
                System.out.println("用户密码======="+user.getPassword()+"用户名========"+user.getUserName());
                //创建AuthenticationInfo对象
                AuthenticationInfo info=new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());
                return info;//此处如果返回，就会立即进入到密码比较器
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;//返回null就会出异常
    }


}
