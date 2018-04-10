package com.itplayer.core.validate;


import org.springframework.security.core.AuthenticationException;

/**
 * Created by caijun.yang on 2018/4/10
 */
public class ValidateCodeException extends AuthenticationException {
    public ValidateCodeException(String explanation) {
        super(explanation);
    }
}
