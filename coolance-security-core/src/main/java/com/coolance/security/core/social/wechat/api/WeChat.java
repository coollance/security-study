package com.coolance.security.core.social.wechat.api;

/**
 * @ClassName WeChat
 * @Description ServiceProvider中的Api
 * @Author Coolance
 * @Version
 * @Date 2019/8/31 13:55
 */
public interface WeChat {
    /**
     * 获取微信用户信息
     * @param openId
     * @return
     */
    WeChatUserInfo getWeChatUserInfo(String openId);

}
