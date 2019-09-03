package com.coolance.core.validate.code;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @ClassName ValidateCode
 * @Description 验证码实体类
 * @Author Coolance
 * @Version
 * @Date 2019/8/27 20:58
 */
@Data
public class ValidateCode implements Serializable {

    private String code;

    private LocalDateTime expiredTime;

    public ValidateCode(String code, int expiredIn) {
        this.code = code;
        this.expiredTime = LocalDateTime.now().plusSeconds(expiredIn);
    }

    public ValidateCode(String code, LocalDateTime expiredTime) {
        this.code = code;
        this.expiredTime = expiredTime;
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expiredTime);
    }
}
