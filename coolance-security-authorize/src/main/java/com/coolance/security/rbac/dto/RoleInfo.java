/**
 * 
 */
package com.coolance.security.rbac.dto;

/**
 * @ClassName RoleInfo
 * @Description 角色包装类
 * @Author Coolance
 * @Version
 * @Date 2019/9/13 14:27
 */
public class RoleInfo {
	
	private Long id;
	
	private String name;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
