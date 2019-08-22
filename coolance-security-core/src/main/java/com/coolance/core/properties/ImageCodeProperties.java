package com.coolance.core.properties;

import lombok.Data;

/**
 * @ClassName ImageCodeProperties
 * @Description 图形验证码基本参数配置类
 * @Author Coolance
 * @Version
 * @Date 2019/8/22 21:26
 */
@Data
public class ImageCodeProperties {
    private int width = 67;
    private int height = 23;
    private int length = 4;
    private int expiredIn = 60;
    private String url;
}
