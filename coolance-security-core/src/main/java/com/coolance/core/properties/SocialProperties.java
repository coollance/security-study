package com.coolance.core.properties;

import lombok.Data;

/**
 * @ClassName SocialProperties
 * @Description 社交登录配置属性类
 * @Author Coolance
 * @Version
 * @Date 2019/8/29 15:02
 */
@Data
public class SocialProperties {
    private QQProperties qq = new QQProperties();

    private String filterProcessesUrl = "/auth";
}
