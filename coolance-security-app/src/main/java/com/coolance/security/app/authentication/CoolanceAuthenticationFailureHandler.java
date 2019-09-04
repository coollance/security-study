package com.coolance.security.app.authentication;

import com.coolance.security.core.properties.LoginResponseType;
import com.coolance.security.core.properties.SecurityProperties;
import com.coolance.security.core.support.SimpleResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName CoolanceAuthenticationFailureHandler
 * @Description 自定义登录失败处理类
 * @Author Coolance
 * @Version
 * @Date 2019/8/20 11:38
 */
@Slf4j
@Component("coolanceAuthenticationFailureHandler")
public class CoolanceAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException e) throws IOException, ServletException {
        log.info("login failure");
        if(LoginResponseType.JSON.equals(securityProperties.getBrowser().getLoginResponseType())) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(objectMapper.writeValueAsString(new SimpleResponse(e.getMessage())));
        } else {
            super.onAuthenticationFailure(request, response, e);
        }

    }
}
