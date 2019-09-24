/**
 * 
 */
package com.coolance.security.rbac.repository;

import com.coolance.security.rbac.domain.Role;
import org.springframework.stereotype.Repository;

/**
 * @ClassName RoleRepository
 * @Description jpa数据库操作
 * @Author Coolance
 * @Version
 * @Date 2019/9/13 14:27
 */
@Repository
public interface RoleRepository extends CoolanceRepository<Role> {

}
