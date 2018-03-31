package com.itplayer.security.authentication;


import com.itplayer.core.propertis.LoginType;
import com.itplayer.core.propertis.SecurityProperties;
import com.itplayer.core.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by caijun.yang on 2018/3/31
 * 用于自定义登录成功后的操作
 */
@Component
public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {// implements AuthenticationSuccessHandler {
    private Logger logger = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);


    @Autowired
    private SecurityProperties securityProperties;

    /**
     * Authentication 封装的认证信息，包含 人情请求的信息，如ip，sessioin，以及自定义的UserDetail的用户信息
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        if (LoginType.JSON.equals(securityProperties.getAuthority().getLoginType())) {

            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(JsonUtils.obj2Str(authentication));
        } else {
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }
}
