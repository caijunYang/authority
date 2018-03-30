package com.itplayer.security.support;

/**
 * Created by caijun.yang on 2018/3/30
 */
public class CommonResponse {
    private Object object;

    public CommonResponse(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
