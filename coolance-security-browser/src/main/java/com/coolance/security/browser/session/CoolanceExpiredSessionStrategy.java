package com.coolance.security.browser.session;

import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @ClassName CoolanceExpiredSessionStrategy
 * @Description 并发登录session处理策略
 * @Author Coolance
 * @Version
 * @Date 2019/9/3 9:59
 */
public class CoolanceExpiredSessionStrategy extends AbstractSessionStrategy implements SessionInformationExpiredStrategy {

    /**
     * @param invalidSessionUrl
     */
    public CoolanceExpiredSessionStrategy(String invalidSessionUrl) {
        super(invalidSessionUrl);
    }

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
        onSessionInvalid(event.getRequest(), event.getResponse());
    }

    @Override
    public boolean isConcurrency() {
        return true;
    }
}
