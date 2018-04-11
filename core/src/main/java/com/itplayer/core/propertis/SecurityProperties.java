package com.itplayer.core.propertis;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by caijun.yang on 2018/3/30
 */
@ConfigurationProperties(prefix = "itplayer.security")
public class SecurityProperties {

    private AuthorityProperties authority = new AuthorityProperties();

    private ValidateCodeProperties code = new ValidateCodeProperties();

    public AuthorityProperties getAuthority() {
        return authority;
    }

    public void setAuthority(AuthorityProperties authority) {
        this.authority = authority;
    }

    public ValidateCodeProperties getCode() {
        return code;
    }

    public void setCode(ValidateCodeProperties code) {
        this.code = code;
    }
}
