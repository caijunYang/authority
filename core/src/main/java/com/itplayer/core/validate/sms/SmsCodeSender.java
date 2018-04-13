package com.itplayer.core.validate.sms;

/**
 * Created by caijun.yang on 2018/4/13
 */
public interface SmsCodeSender {

    void sender(String mobile,String code);
}
