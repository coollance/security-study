package com.coolance.core.social.qq.connet;

import com.coolance.core.social.qq.api.QQ;
import com.coolance.core.social.qq.api.QQUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * @ClassName QQAdapter
 * @Description ApiAdapter api适配器 OAuth2Connection
 * @Author Coolance
 * @Version
 * @Date 2019/8/29 14:17
 */
@Slf4j
public class QQAdapter implements ApiAdapter<QQ> {
    /**
     * 测试QQ登录是否可用
     *
     * @param api
     * @return
     */
    @Override
    public boolean test(QQ api) {
        log.info("QQAdapter test()" + api);
        return true;
    }

    /**
     * QQ用户信息生成标准connection数据结构
     *
     * @param api
     * @param values
     */
    @Override
    public void setConnectionValues(QQ api, ConnectionValues values) {
        QQUserInfo userInfo = api.getQQUserInfo();
        values.setDisplayName(userInfo.getNickname());
        //个人首页
        values.setProfileUrl(null);
        values.setImageUrl(userInfo.getFigureurl_qq_1());
        values.setProviderUserId(userInfo.getOpenId());
    }

    /**
     * 绑定与解绑时用
     *
     * @param api
     * @return
     */
    @Override
    public UserProfile fetchUserProfile(QQ api) {
        return null;
    }

    /**
     * 发送消息更新微博之类
     *
     * @param api
     * @param message
     */
    @Override
    public void updateStatus(QQ api, String message) {
        //do no thing
    }
}
