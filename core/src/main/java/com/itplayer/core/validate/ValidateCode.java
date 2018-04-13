package com.itplayer.core.validate;

import java.time.LocalDateTime;

/**
 * Created by caijun.yang on 2018/4/10
 */
public class ValidateCode {

    private String code;
    private LocalDateTime localDateTime;

    public ValidateCode(String code, LocalDateTime localDateTime) {

        this.code = code;
        this.localDateTime = localDateTime;
    }

    public ValidateCode(String code, int expireIn) {

        this.code = code;
        this.localDateTime = LocalDateTime.now().plusSeconds(expireIn);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public boolean isExpried() {
        return LocalDateTime.now().isAfter(localDateTime);
    }
}
