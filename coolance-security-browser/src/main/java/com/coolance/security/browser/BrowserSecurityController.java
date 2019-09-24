package com.coolance.security.browser;

import com.coolance.security.core.properties.SecurityProperties;
import com.coolance.security.core.support.SimpleResponse;
import com.coolance.security.core.support.SocialUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName BrowserSecurityController
 * @Description 处理不同类型的请求
 * @Author Coolance
 * @Version
 * @Date 2019/8/20 10:10
 */
@Slf4j
@RestController
public class BrowserSecurityController {

    @Autowired
    private SecurityProperties securityProperties;

    private static final String HTML = ".html";

    private RequestCache requestCache = new HttpSessionRequestCache();

    @Autowired
    private ProviderSignInUtils providerSignInUtils;

    /**
     * Spring用于跳转的工具
     */
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @RequestMapping("/authentication/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public SimpleResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest != null) {
            String targetUrl = savedRequest.getRedirectUrl();
            log.info("引发跳转的请求是:" + targetUrl);
            if (StringUtils.endsWithIgnoreCase(targetUrl, HTML)) {
                redirectStrategy.sendRedirect(request, response, securityProperties.getBrowser().getSignInPage());
            }

        }
        return new SimpleResponse("访问的服务需要身份认证，请引导用户到登录页");
    }

    /**
     * 获取社交用户信息
     * @param request
     * @return
     */
    @GetMapping("/social/user")
    public SocialUserInfo getSocialUserInfo(HttpServletRequest request) {
        Connection<?> connection = providerSignInUtils.getConnectionFromSession(new ServletWebRequest(request));
        SocialUserInfo userInfo = new SocialUserInfo();
        userInfo.setProviderId(connection.getKey().getProviderId());
        userInfo.setProviderUserId(connection.getKey().getProviderUserId());
        userInfo.setNickname(connection.getDisplayName());
        userInfo.setHeadImg(connection.getImageUrl());
        return userInfo;
    }

}
