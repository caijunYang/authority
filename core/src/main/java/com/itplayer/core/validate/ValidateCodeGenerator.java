package com.itplayer.core.validate;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by caijun.yang on 2018/4/11
 */
public interface ValidateCodeGenerator {
    ValidateCode generate(HttpServletRequest request);
}
