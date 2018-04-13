package com.itplayer.core.validate;

import com.itplayer.core.propertis.SecurityProperties;
import com.itplayer.core.validate.sms.DefaultSmsCodeSender;
import com.itplayer.core.validate.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by caijun.yang on 2018/4/11
 */
@Configuration
public class ValidateBeanConfig {

    @Autowired
    SecurityProperties securityProperties;

    @Bean
    @ConditionalOnMissingBean(name = "imageCodeGenerator")
    public ValidateCodeGenerator imageCodeGenerator() {
        AbstractImageCodeGenerator abstractImageCodeGenerator = new AbstractImageCodeGenerator();
        abstractImageCodeGenerator.setSecurityProperties(securityProperties);
        return abstractImageCodeGenerator;
    }
    @Bean
    @ConditionalOnMissingBean(name = "smsCodeGenerator")
    public ValidateCodeGenerator smsCodeGenerator() {
        AbstractSmsCodeGenerator abstractSmsCodeGenerator = new AbstractSmsCodeGenerator();
        abstractSmsCodeGenerator.setSecurityProperties(securityProperties);
        return abstractSmsCodeGenerator;
    }

    @Bean
    @ConditionalOnMissingBean(name = "smsCodeSender")
    public SmsCodeSender smsCodeSender() {
        return new DefaultSmsCodeSender();
    }
}
