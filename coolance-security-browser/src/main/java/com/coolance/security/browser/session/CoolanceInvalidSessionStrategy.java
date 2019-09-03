/**
 * 
 */
package com.coolance.security.browser.session;

import org.springframework.security.web.session.InvalidSessionStrategy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName CoolanceInvalidSessionStrategy
 * @Description session失效处理策略
 * @Author Coolance
 * @Version
 * @Date 2019/9/3 10:19
 */
public class CoolanceInvalidSessionStrategy extends AbstractSessionStrategy implements InvalidSessionStrategy {

	public CoolanceInvalidSessionStrategy(String invalidSessionUrl) {
		super(invalidSessionUrl);
	}

	@Override
	public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		onSessionInvalid(request, response);
	}

}
