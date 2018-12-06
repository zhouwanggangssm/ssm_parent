package cn.xt.shiro;

import javax.servlet.ServletRequest;

import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

public class loginFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected void issueSuccessRedirect(ServletRequest request, ServletResponse response)
            throws Exception{
        WebUtils.issueRedirect(request, response,getSuccessUrl(), null, true);
    }
}