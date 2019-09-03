package com.coolance.security.browser.logout;

import com.coolance.security.browser.support.SimpleResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName CoolanceLogoutSuccessHandler
 * @Description 退出登录成功处理器
 * @Author Coolance
 * @Version
 * @Date 2019/9/3 14:17
 */
@Slf4j
public class CoolanceLogoutSuccessHandler implements LogoutSuccessHandler {
    private String signOutUrl;

    private ObjectMapper objectMapper = new ObjectMapper();

    public CoolanceLogoutSuccessHandler(String signOutUrl) {
        this.signOutUrl = signOutUrl;
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("退出成功");
        if (StringUtils.isBlank(signOutUrl)) {
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(objectMapper.writeValueAsString(new SimpleResponse("退出成功")));
        } else {
            response.sendRedirect(signOutUrl);
        }
    }
}
