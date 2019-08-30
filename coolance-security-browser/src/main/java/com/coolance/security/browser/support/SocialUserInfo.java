package com.coolance.security.browser.support;

import lombok.Data;

/**
 * @ClassName SocialUserInfo
 * @Description 社交用户信息
 * @Author Coolance
 * @Version
 * @Date 2019/8/30 11:00
 */
@Data
public class SocialUserInfo {
    /**
     * 社交用户提供方id:QQ、微信
     */
    private String providerId;
    /**
     * 社交用户提供方的用户id
     */
    private String providerUserId;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 头像
     */
    private String headImg;
}
