/**
 * 
 */
package com.coolance.security.rbac.authentication;

import com.coolance.security.rbac.domain.Admin;
import com.coolance.security.rbac.repository.AdminRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName RbacUserDetailsServiceImpl
 * @Description UserDetailsService实现类
 * @Author Coolance
 * @Version
 * @Date 2019/9/13 14:27
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class RbacUserDetailsServiceImpl implements UserDetailsService, SocialUserDetailsService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AdminRepository adminRepository;

	/**
	 * (non-Javadoc)
	 * 
	 * @see UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("表单登录用户名:" + username);
		Admin admin = adminRepository.findByUsername(username);
		admin.getUrls();
		return admin;
	}

	@Override
	public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
		return null;
	}
}
