/**
 * 
 */
package com.coolance.security.rbac.repository;

import com.coolance.security.rbac.domain.Resource;
import org.springframework.stereotype.Repository;

/**
 * @ClassName ResourceRepository
 * @Description jpa数据库操作
 * @Author Coolance
 * @Version
 * @Date 2019/9/13 14:27
 */
@Repository
public interface ResourceRepository extends CoolanceRepository<Resource> {
	/**
	 * 根据名字查询资源
	 * @param name
	 * @return
	 */
	Resource findByName(String name);

}
