package com.itplayer.core.validate;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by caijun.yang on 2018/4/10
 */
public class ValidateCodeFilter extends OncePerRequestFilter {
    private static final String SESSION_KEY = "IMAGE_CODE";
    private AuthenticationFailureHandler authenticationFailureHandler;

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (StringUtils.equals("", request.getRequestURI()) && StringUtils.equals(request.getMethod(), "POST")) {

            try {
                validate(new ServletWebRequest(request));
            } catch (ValidateCodeException e) {
                authenticationFailureHandler.onAuthenticationFailure(request, response, e);
            }

        } else {
            filterChain.doFilter(request, response);
        }
    }

    private void validate(ServletWebRequest request) throws ServletRequestBindingException {
        ImageCode codeInSssion = (ImageCode) sessionStrategy.getAttribute(request, SESSION_KEY);
        String imageCode = ServletRequestUtils.getStringParameter(request.getRequest(), "imageCode");
        if(StringUtils.isBlank(imageCode)){
            throw new ValidateCodeException("验证码不能为工");
        }
        if(null == codeInSssion){
            throw new ValidateCodeException("验证码不能为工");
        }
        if(codeInSssion.isExpried()){
            sessionStrategy.removeAttribute(request,SESSION_KEY);
            throw new ValidateCodeException("验证码不过期");
        }
        if(!codeInSssion.equals(codeInSssion.getCode())){
            throw new ValidateCodeException("验证码不过期");
        }
        sessionStrategy.removeAttribute(request,SESSION_KEY);
    }
}
