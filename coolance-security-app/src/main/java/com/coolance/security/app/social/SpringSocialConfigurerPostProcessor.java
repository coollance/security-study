/**
 * 
 */
package com.coolance.security.app.social;

import com.coolance.security.core.properties.SecurityConstants;
import com.coolance.security.core.social.CoolanceSpringSocialConfigurer;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @ClassName SpringSocialConfigurer
 * @Description SpringSocialConfigurer后置处理类
 * @Author Coolance
 * @Version
 * @Date 2019/9/9 11:15
 */
@Component
public class SpringSocialConfigurerPostProcessor implements BeanPostProcessor {
	private static final String BEAN_NAME = "coolanceSocialSecurityConfig";

	/**
	 * (non-Javadoc)
	 * @see org.springframework.beans.factory.config.BeanPostProcessor
	 * #postProcessBeforeInitialization(java.lang.Object, java.lang.String)
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	/**
	 * (non-Javadoc)
	 * @see org.springframework.beans.factory.config.BeanPostProcessor
	 * #postProcessAfterInitialization(java.lang.Object, java.lang.String)
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(StringUtils.equals(beanName, BEAN_NAME)){
			CoolanceSpringSocialConfigurer config = (CoolanceSpringSocialConfigurer)bean;
			config.signupUrl(SecurityConstants.DEFAULT_SOCIAL_USER_INFO_URL);
			return config;
		}
		return bean;
	}

}
