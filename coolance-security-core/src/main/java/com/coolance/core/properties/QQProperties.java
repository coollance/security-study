package com.coolance.core.properties;

import lombok.Data;
import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @ClassName QQProperties
 * @Description QQ登录基本参数属性类
 * @Author Coolance
 * @Version
 * @Date 2019/8/29 14:59
 */
@Data
public class QQProperties extends SocialProperties {

    private String providerId = "qq";

}
