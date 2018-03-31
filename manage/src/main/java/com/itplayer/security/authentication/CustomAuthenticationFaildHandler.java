package com.itplayer.security.authentication;

import com.itplayer.core.propertis.LoginType;
import com.itplayer.core.propertis.SecurityProperties;
import com.itplayer.core.utils.JsonUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by caijun.yang on 2018/3/31
 * 登陆失败的处理
 */
@Component
public class CustomAuthenticationFaildHandler extends SimpleUrlAuthenticationFailureHandler {//implements AuthenticationFailureHandler {

    /**
     * AuthenticationException 封装异常信息，每种错误会有对应的异常错误实现
     */


    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException authenticationException) throws IOException, ServletException {

        if (LoginType.JSON.equals(securityProperties.getAuthority().getLoginType())) {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(JsonUtils.obj2Str(authenticationException));
        } else {
            super.onAuthenticationFailure(request, response, authenticationException);
        }
    }
}
