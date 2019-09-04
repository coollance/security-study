package com.coolance.security.core.social;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @ClassName CoolanceSpringSocialConfigurer
 * @Description 将SocialAuthenticationFilter配置到Spring Security过滤器链上的配置类
 * @Author Coolance
 * @Version
 * @Date 2019/8/30 15:14
 */
public class CoolanceSpringSocialConfigurer extends SpringSocialConfigurer {

    private String filterProcessesUrl;

    public CoolanceSpringSocialConfigurer(String filterProcessesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }

    /**
     * 定制个性化SocialAuthenticationFilter
     * @param object
     * @param <T>
     * @return
     */
    @Override
    protected <T> T postProcess(T object) {
        SocialAuthenticationFilter filter = (SocialAuthenticationFilter)super.postProcess(object);
        filter.setFilterProcessesUrl(filterProcessesUrl);
        return (T)filter;
    }
}
