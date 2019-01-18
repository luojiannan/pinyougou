package com.pinyougou.backend.config.shiro;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author ljn
 * @date 2019/1/16.
 * 验证码认证
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

    /**
     * 验证码校验
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession();
        //取出session中的正确验证码
        String validateCode = (String) session.getAttribute("validateCode");
        String randomCode = httpServletRequest.getParameter("randomCode");
        if (StringUtils.isBlank(randomCode) || !randomCode.equals(validateCode)) {
            httpServletRequest.setAttribute("shiroLoginFailure", "randomCodeError");
            //验证码错误，拒接访问，不在校验帐号，密码
            return true;
        }
        return super.onAccessDenied(request, response);
    }
}
