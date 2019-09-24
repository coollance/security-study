/**
 * 
 */
package com.coolance.security.rbac.web.controller.support;

/**
 * @ClassName SimpleResponse
 * @Description rest返回包装类型
 * @Author Coolance
 * @Version
 * @Date 2019/9/13 14:27
 */
public class SimpleResponse {
	
	public SimpleResponse(Object content){
		this.content = content;
	}
	
	private Object content;

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}
	
}
