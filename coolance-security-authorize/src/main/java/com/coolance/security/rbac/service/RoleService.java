/**
 *
 */
package com.coolance.security.rbac.service;


import com.coolance.security.rbac.dto.RoleInfo;

import java.util.List;

/**
 * @ClassName RoleService
 * @Description 角色服务
 * @Author Coolance
 * @Version
 * @Date 2019/9/13 14:27
 */
public interface RoleService {

    /**
     * 创建角色
     *
     * @param roleInfo
     * @return
     */
    RoleInfo create(RoleInfo roleInfo);

    /**
     * 修改角色
     *
     * @param roleInfo
     * @return
     */
    RoleInfo update(RoleInfo roleInfo);

    /**
     * 删除角色
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 获取角色详细信息
     *
     * @param id
     * @return
     */
    RoleInfo getInfo(Long id);

    /**
     * 查询所有角色
     *
     * @return
     */
    List<RoleInfo> findAll();

    /**
     * 获取角色资源
     *
     * @param id
     * @return
     */
    String[] getRoleResources(Long id);

    /**
     * 设置角色资源
     *
     * @param id
     * @param ids
     */
    void setRoleResources(Long id, String ids);

}
