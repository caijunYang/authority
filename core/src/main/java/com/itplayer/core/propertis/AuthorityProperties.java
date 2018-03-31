package com.itplayer.core.propertis;

/**
 * Created by caijun.yang on 2018/3/30
 */
public class AuthorityProperties {
    private String loginPage = "/itplayer_login.html";

    private LoginType loginType = LoginType.JSON;

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }
}
