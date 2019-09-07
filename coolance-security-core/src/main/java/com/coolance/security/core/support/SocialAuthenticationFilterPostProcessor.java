package com.coolance.security.core.support;

import org.springframework.social.security.SocialAuthenticationFilter;

/**
 * @ClassName SocialAuthenticationFilterPostProcessor
 * @Description SocialAuthenticationFilter后置处理器
 * @Author Coolance
 * @Version
 * @Date 2019/9/6 17:31
 */
public interface SocialAuthenticationFilterPostProcessor {
    /**
     * 后置处理方法
     * @param filter
     */
    void process(SocialAuthenticationFilter filter);
}
