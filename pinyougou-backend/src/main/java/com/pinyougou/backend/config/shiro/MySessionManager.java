package com.pinyougou.backend.config.shiro;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

/**
 * @author ljn
 * @date 2019/1/18.
 */
public class MySessionManager extends DefaultWebSessionManager {

    private static final String AUTHORIZATION = "authToken";

    public MySessionManager(){
        super();
    }

    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response){
        String token = WebUtils.toHttp(request).getHeader(AUTHORIZATION);
        System.out.println("token："+token);
        if(StringUtils.isEmpty(token)){
            //如果没有携带id参数则按照父类的方式在cookie进行获取
            System.out.println("super："+super.getSessionId(request, response));
            return super.getSessionId(request, response);
        }else{
            //如果请求头中有 authToken 则其值为sessionId
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, token);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID,token);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID,Boolean.TRUE);
            return token;
        }
    }
}
