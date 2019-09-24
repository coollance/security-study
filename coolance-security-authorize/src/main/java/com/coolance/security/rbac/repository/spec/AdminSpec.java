/**
 * 
 */
package com.coolance.security.rbac.repository.spec;

import com.coolance.security.rbac.domain.Admin;
import com.coolance.security.rbac.dto.AdminCondition;
import com.coolance.security.rbac.repository.support.CoolanceSpecification;
import com.coolance.security.rbac.repository.support.QueryWrapper;

/**
 * @ClassName AdminSpec
 * @Description 按条件查询
 * @Author Coolance
 * @Version
 * @Date 2019/9/13 14:27
 */
public class AdminSpec extends CoolanceSpecification<Admin, AdminCondition> {

	public AdminSpec(AdminCondition condition) {
		super(condition);
	}

	@Override
	protected void addCondition(QueryWrapper<Admin> queryWrapper) {
		addLikeCondition(queryWrapper, "username");
	}

}
