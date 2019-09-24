/**
 * 
 */
package com.coolance.security.rbac.service.impl;


import com.coolance.security.rbac.domain.Admin;
import com.coolance.security.rbac.service.RbacService;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * @ClassName RbacServiceImpl
 * @Description 自定义权限表达式处理类
 * @Author Coolance
 * @Version
 * @Date 2019/9/13 14:27
 */
@Component("rbacService")
public class RbacServiceImpl implements RbacService {
	public static final String ADMIN = "admin";

	private AntPathMatcher antPathMatcher = new AntPathMatcher();

	@Override
	public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
		Object principal = authentication.getPrincipal();

		boolean hasPermission = false;

		if (principal instanceof Admin) {
			//如果用户名是admin，就永远返回true
			if (StringUtils.equals(((Admin) principal).getUsername(), ADMIN)) {
				hasPermission = true;
			} else {
				// 读取用户所拥有权限的所有URL
				Set<String> urls = ((Admin) principal).getUrls();
				for (String url : urls) {
					if (antPathMatcher.match(url, request.getRequestURI())) {
						hasPermission = true;
						break;
					}
				}
			}
		}

		return hasPermission;
	}

}
