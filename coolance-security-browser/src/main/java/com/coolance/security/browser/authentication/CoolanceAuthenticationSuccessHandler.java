package com.coolance.security.browser.authentication;

import com.coolance.security.core.properties.LoginResponseType;
import com.coolance.security.core.properties.SecurityProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName CoolanceAuthenticationSuccessHandler
 * @Description 自定义登录成功处理类
 * @Author Coolance
 * @Version
 * @Date 2019/8/20 11:24
 */
@Slf4j
@Component("coolanceAuthenticationSuccessHandler")
public class CoolanceAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityProperties securityProperties;

    private RequestCache requestCache = new HttpSessionRequestCache();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        log.info("login success");
        if (LoginResponseType.JSON.equals(securityProperties.getBrowser().getLoginResponseType())) {
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(objectMapper.writeValueAsString(authentication));
        } else {
            // 如果设置了coolance.security.browser.singInSuccessUrl，总是跳到设置的地址上
            // 如果没设置，则尝试跳转到登录之前访问的地址上，如果登录前访问地址为空，则跳到网站根路径上
            if (StringUtils.isNotBlank(securityProperties.getBrowser().getSignInSuccessUrl())) {
                requestCache.removeRequest(request, response);
                setAlwaysUseDefaultTargetUrl(true);
                setDefaultTargetUrl(securityProperties.getBrowser().getSignInSuccessUrl());
            }
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }
}
