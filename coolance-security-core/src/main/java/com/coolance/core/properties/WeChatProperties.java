package com.coolance.core.properties;

import lombok.Data;
import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @ClassName 微信Properties
 * @Description 微信登录基本参数属性类
 * @Author Coolance
 * @Version
 * @Date 2019/8/29 14:59
 */
@Data
public class WeChatProperties extends SocialProperties {

    /**
     * 第三方id，用来决定发起第三方登录的url，默认是WeChat
     */
    private String providerId = "weixin";

}
