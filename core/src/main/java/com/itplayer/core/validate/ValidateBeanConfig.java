package com.itplayer.core.validate;

import com.itplayer.core.propertis.SecurityProperties;
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
    public ValidateCodeGenerator abstractValidateCodeGenerator() {
        AbstractImageCodeGenerator abstractImageCodeGenerator = new AbstractImageCodeGenerator();
        abstractImageCodeGenerator.setSecurityProperties(securityProperties);
        return abstractImageCodeGenerator;
    }
}
