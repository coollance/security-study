package com.coolance.core.social.wechat.connet;

import com.coolance.core.social.wechat.api.WeChat;
import com.coolance.core.social.wechat.api.WeChatUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * @ClassName WeChatAdapter
 * @Description WeChatAdapter api适配器 OAuth2Connection
 * @Author Coolance
 * @Version
 * @Date 2019/9/2 08:50
 */
@Slf4j
public class WeChatAdapter implements ApiAdapter<WeChat> {

    private String openId;

    public WeChatAdapter() {
    }

    public WeChatAdapter(String openId) {
        this.openId = openId;
    }

    /**
     * 测试微信登录是否可用
     *
     * @param api
     * @return
     */
    @Override
    public boolean test(WeChat api) {
        log.info("WeChatAdapter test()" + api);
        return true;
    }

    /**
     * 微信用户信息生成标准connection数据结构
     *
     * @param api
     * @param values
     */
    @Override
    public void setConnectionValues(WeChat api, ConnectionValues values) {
        WeChatUserInfo userInfo = api.getWeChatUserInfo(openId);
        values.setDisplayName(userInfo.getNickname());
        values.setImageUrl(userInfo.getHeadimgurl());
        values.setProviderUserId(userInfo.getOpenid());
    }

    /**
     * 绑定与解绑时用
     *
     * @param api
     * @return
     */
    @Override
    public UserProfile fetchUserProfile(WeChat api) {
        return null;
    }

    /**
     * 发送消息更新微博之类
     *
     * @param api
     * @param message
     */
    @Override
    public void updateStatus(WeChat api, String message) {
        //do no thing
    }
}
