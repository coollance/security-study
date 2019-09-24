/**
 * 
 */
package com.coolance.security.rbac.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName RbacService
 * @Description 自定义权限表达式处理服务接口
 * @Author Coolance
 * @Version
 * @Date 2019/9/13 14:27
 */
public interface RbacService {
	/**
	 * 判断是否有权限
	 * @param request
	 * @param authentication
	 * @return
	 */
	boolean hasPermission(HttpServletRequest request, Authentication authentication);

}
