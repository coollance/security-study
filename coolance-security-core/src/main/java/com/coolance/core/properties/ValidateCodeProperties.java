package com.coolance.core.properties;

import lombok.Data;

/**
 * @ClassName ValidateCodeProperties
 * @Description 验证码配置类
 * @Author Coolance
 * @Version
 * @Date 2019/8/22 21:31
 */
@Data
public class ValidateCodeProperties {
    private ImageCodeProperties image = new ImageCodeProperties();

    private SmsCodeProperties sms = new SmsCodeProperties();
}
