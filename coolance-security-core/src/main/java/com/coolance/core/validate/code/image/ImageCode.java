package com.coolance.core.validate.code.image;

import com.coolance.core.validate.code.ValidateCode;
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
public class ImageCode extends ValidateCode {

    private BufferedImage image;

    public ImageCode(BufferedImage image, String code, int expiredIn) {
        super(code, expiredIn);
        this.image = image;
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expiredTime) {
        super(code, expiredTime);
        this.image = image;
    }
}
