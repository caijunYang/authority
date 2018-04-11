package com.itplayer.security;

import com.itplayer.core.propertis.SecurityProperties;
import com.itplayer.core.validate.ValidateCodeFilter;
import com.itplayer.security.authentication.CustomAuthenticationFaildHandler;
import com.itplayer.security.authentication.CustomAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
    @Autowired
    private CustomAuthenticationFaildHandler customAuthenticationFaildHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setAuthenticationFailureHandler(customAuthenticationFaildHandler);
        validateCodeFilter.setSecurityProperties(securityProperties);
        validateCodeFilter.afterPropertiesSet();

        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class).
                formLogin().loginPage("/resources/itplayer_login.html")//用表单登录进行身份认证
                .loginProcessingUrl("/itplayer_login")//登录地址
                .successHandler(customAuthenticationSuccessHandler).failureHandler(customAuthenticationFaildHandler)
                .and()
                .authorizeRequests().antMatchers("/authentication/require", securityProperties.getAuthority().getLoginPage(), "/code/image").permitAll()//搜全配置，所有请求都需要进行份验证排除部分
                .anyRequest()
                .authenticated()
                .and().csrf().disable();//暂时关闭跨站伪造防护功能
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
