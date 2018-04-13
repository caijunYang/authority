package com.itplayer.core.validate;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * Created by caijun.yang on 2018/4/10
 */
public class ImageCode extends ValidateCode {
    private BufferedImage image;

    public ImageCode(BufferedImage image, String code, LocalDateTime localDateTime) {
        super(code,localDateTime);
        this.image = image;

    }

    public ImageCode(BufferedImage image, String code, int expireIn) {
        super(code,expireIn);
        this.image = image;
    }


    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
