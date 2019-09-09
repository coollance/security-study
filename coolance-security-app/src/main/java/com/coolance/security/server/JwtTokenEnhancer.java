/**
 * 
 */
package com.coolance.security.server;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName JwtTokenEnhancer
 * @Description jwt增强器
 * @Author Coolance
 * @Version
 * @Date 2019/9/9 14:41
 */
public class JwtTokenEnhancer implements TokenEnhancer {

	/**
	 * (non-Javadoc)
	 * @see org.springframework.security.oauth2.provider.token.TokenEnhancer
	 * #enhance(org.springframework.security.oauth2.common.OAuth2AccessToken, org.springframework.security.oauth2.provider.OAuth2Authentication)
	 */
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> info = new HashMap<>(1);
		info.put("company", "coolance");
		
		((DefaultOAuth2AccessToken)accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}

}
