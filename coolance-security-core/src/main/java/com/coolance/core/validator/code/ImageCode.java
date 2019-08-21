package com.coolance.core.validator.code;

import lombok.Data;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @ClassName ImageCode
 * @Description 图片验证码包装类
 * @Author Coolance
 * @Version
 * @Date 2019/8/20 20:57
 */
@Data
public class ImageCode {

    private BufferedImage image;

    private String code;

    private LocalDateTime expiredTime;

    public ImageCode(BufferedImage image, String code, int expiredIn) {
        this.image = image;
        this.code = code;
        this.expiredTime = LocalDateTime.now().plusSeconds(expiredIn);
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expiredTime);
    }
}
