package cn.xt.shiro;

import cn.xt.utils.Encrypt;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;


public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {


    //密码比较的方法 token代表用户再界面输入的用户名和密码  info代表从数据库中得到加密数据
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        //1.向下转型
        UsernamePasswordToken upToken= (UsernamePasswordToken) token;

        //2.将用户在界面输入的原始密码加密
        Object pwd= Encrypt.md5(new String(upToken.getPassword()),upToken.getUsername());
        System.out.println("用户密码==================="+pwd);

        //3.取出数据库中加密的密码
        Object dbPwd=info.getCredentials();
        System.out.println("加密密码==================="+dbPwd);

        return this.equals(pwd,dbPwd);
    }
}
