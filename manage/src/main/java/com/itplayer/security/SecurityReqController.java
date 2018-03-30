package com.itplayer.security;


import com.itplayer.core.propertis.SecurityProperties;
import com.itplayer.security.support.CommonResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by caijun.yang on 2018/3/30
 */
@RestController
public class SecurityReqController {
    //*
    private RequestCache requestCache = new HttpSessionRequestCache();

    @Autowired
    private SecurityProperties securityProperties;

    @RequestMapping("/authentication/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public CommonResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (null != savedRequest) {
            String target = savedRequest.getRedirectUrl();
            if (StringUtils.endsWithIgnoreCase(target, ".html")) {
                new DefaultRedirectStrategy().sendRedirect(request, response, securityProperties.getAuthority().getLoginPage());
            }
        }
        return new CommonResponse("需要身份认证");
    }
}
