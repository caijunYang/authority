package com.itplayer.core.propertis;

/**
 * Created by caijun.yang on 2018/4/11
 */
public class SmsCodeProperties {

    private int length = 6;
    private int expirein = 60;
    private String url;


    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpirein() {
        return expirein;
    }

    public void setExpirein(int expirein) {
        this.expirein = expirein;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
