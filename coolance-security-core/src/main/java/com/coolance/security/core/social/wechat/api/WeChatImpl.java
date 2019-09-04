package com.coolance.security.core.social.wechat.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @ClassName WeChatImpl
 * @Description Api实现类
 * @Author Coolance
 * @Version
 * @Date 2019/8/31 14:05
 */
public class WeChatImpl extends AbstractOAuth2ApiBinding implements WeChat {

    private static final String URL_GET_USER_INFO = "https://api.weixin.qq.com/sns/userinfo?openid=";

    private static final String ERROR_CODE = "errcode";

    public WeChatImpl(String accessToken) {
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
    }

    /**
     * 默认注册的StringHttpMessageConverter字符集为ISO-8859-1，而微信返回的是UTF-8的，所以覆盖了原来的方法。
     * @return
     */
    @Override
    protected List<HttpMessageConverter<?>> getMessageConverters() {
        List<HttpMessageConverter<?>> converters = super.getMessageConverters();
        converters.remove(0);
        converters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        return converters;
    }

    /**
     * 获取微信用户信息
     * @param openId
     * @return
     */
    @Override
    public WeChatUserInfo getWeChatUserInfo(String openId) {
        String url = URL_GET_USER_INFO + openId;
        String response = getRestTemplate().getForObject(url, String.class);

        if(StringUtils.contains(response, ERROR_CODE)) {
            return null;
        }

        WeChatUserInfo profile = null;

        try {
            profile = new ObjectMapper().readValue(response, WeChatUserInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return profile;
    }
}
