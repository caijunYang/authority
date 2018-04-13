package com.itplayer.core.validate.sms;

/**
 * Created by caijun.yang on 2018/4/13
 */
public class DefaultSmsCodeSender implements SmsCodeSender {


    @Override
    public void sender(String mobile, String code) {
        System.out.println("向" + mobile + "验证码为:" + code);
    }
}
