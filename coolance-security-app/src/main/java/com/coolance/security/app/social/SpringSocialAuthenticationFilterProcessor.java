package com.coolance.security.app.social;

import com.coolance.security.core.support.SocialAuthenticationFilterPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * @ClassName SpringSocialAuthenticationFilterProcessor
 * @Description SocialAuthenticationFilter后置处理，社交登录成功处理逻辑
 * @Author Coolance
 * @Version
 * @Date 2019/9/7 10:31
 */
@Component
public class SpringSocialAuthenticationFilterProcessor implements SocialAuthenticationFilterPostProcessor {

    @Autowired
    private AuthenticationSuccessHandler coolanceAuthenticationSuccessHandler;

    @Override
    public void process(SocialAuthenticationFilter filter) {
        filter.setAuthenticationSuccessHandler(coolanceAuthenticationSuccessHandler);
    }
}
