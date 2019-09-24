/**
 * 
 */
package com.coolance.security.rbac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @ClassName CoolanceRepository
 * @Description jpa数据库操作
 * @Author Coolance
 * @Version
 * @Date 2019/9/13 14:27
 */
@NoRepositoryBean
public interface CoolanceRepository<T> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {

}
