package com.itplayer;

import com.itplayer.core.validate.ImageCode;
import com.itplayer.core.validate.ValidateCodeGenerator;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by caijun.yang on 2018/4/11
 */
//@Component("imageCodeGenerator")
public class DemoImageCode implements ValidateCodeGenerator {
    @Override
    public ImageCode generate(HttpServletRequest request) {
        //自己定义的图形验证码
        return null;
    }
}
