package com.coolance.security.core.properties;

import lombok.Data;

/**
 * @ClassName ImageCodeProperties
 * @Description 短信验证码基本参数配置类
 * @Author Coolance
 * @Version
 * @Date 2019/8/22 21:26
 */
@Data
public class SmsCodeProperties {

    private int length = 6;
    private int expiredIn = 60;
    private String url;
}
