/**
 *
 */
package com.coolance.security.core.social.wechat.connet;

import org.springframework.social.oauth2.AccessGrant;

/**
 * @ClassName WeChatAccessGrant
 * @Description 微信的access_token信息。与标准OAuth2协议不同，微信在获取access_token时会同时返回openId,并没有单独的
 * 通过accessToke换取openId的服务所以在这里继承了标准AccessGrant，添加了openId字段，作为对微信access_token信息的封装。
 * @Author Coolance
 * @Version
 * @Date 2019/9/2 09:53
 */
public class WeChatAccessGrant extends AccessGrant {

    private static final long serialVersionUID = -7243374526633186782L;

    private String openId;

    public WeChatAccessGrant() {
        super("");
    }

    public WeChatAccessGrant(String accessToken, String scope, String refreshToken, Long expiresIn) {
        super(accessToken, scope, refreshToken, expiresIn);
    }

    /**
     * @return the openId
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * @param openId the openId to set
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

}
