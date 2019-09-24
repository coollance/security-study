/**
 * 
 */
package com.coolance.security.rbac.dto;

/**
 * @ClassName AdminCondition
 * @Description 管理员（用户）查询条件
 * @Author Coolance
 * @Version
 * @Date 2019/9/13 14:27
 */
public class AdminCondition {
	
	private String username;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
}
