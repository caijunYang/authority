package com.itplayer.core.validate;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * Created by caijun.yang on 2018/4/10
 */
public class ImageCode {
    private BufferedImage image;
    private String code;
    private LocalDateTime localDateTime;


    public ImageCode(BufferedImage image, String code, LocalDateTime localDateTime) {
        this.image = image;
        this.code = code;
        this.localDateTime = localDateTime;
    }

    public ImageCode(BufferedImage image, String code, int expireIn) {
        this.image = image;
        this.code = code;
        this.localDateTime = LocalDateTime.now().plusSeconds(expireIn);
    }


    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
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
