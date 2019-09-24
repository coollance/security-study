/**
 * 
 */
package com.coolance.security.rbac.repository;

import com.coolance.security.rbac.domain.Admin;
import org.springframework.stereotype.Repository;

/**
 * @ClassName AdminRepository
 * @Description jpa数据库操作
 * @Author Coolance
 * @Version
 * @Date 2019/9/13 14:27
 */
@Repository
public interface AdminRepository extends CoolanceRepository<Admin> {
	/**
	 * 根据username查询用户
	 * @param username
	 * @return
	 */
	Admin findByUsername(String username);

}
