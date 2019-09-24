/**
 * 
 */
package com.coolance.security.rbac.service.impl;


import com.coolance.security.rbac.domain.Admin;
import com.coolance.security.rbac.domain.Resource;
import com.coolance.security.rbac.dto.ResourceInfo;
import com.coolance.security.rbac.repository.AdminRepository;
import com.coolance.security.rbac.repository.ResourceRepository;
import com.coolance.security.rbac.service.ResourceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName ResourceServiceImpl
 * @Description 资源服务
 * @Author Coolance
 * @Version
 * @Date 2019/9/13 14:27
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ResourceServiceImpl implements ResourceService {
	
	@Autowired
	private ResourceRepository resourceRepository;
	@Autowired
	private AdminRepository adminRepository;

	/**
	 *  (non-Javadoc)
	 * @see com.coolance.security.rbac.service.ResourceService#getTree(java.lang.Long)
	 */
	@Override
	public ResourceInfo getTree(Long adminId) {
		Admin admin = adminRepository.findOne(adminId);
		return resourceRepository.findByName("根节点").toTree(admin);
	}

	/**
	 *  (non-Javadoc)
	 * @see com.coolance.security.rbac.service.ResourceService#getInfo(java.lang.Long)
	 */
	@Override
	public ResourceInfo getInfo(Long id) {
		Resource resource = resourceRepository.findOne(id);
		ResourceInfo resourceInfo = new ResourceInfo();
		BeanUtils.copyProperties(resource, resourceInfo);
		return resourceInfo;
	}

	@Override
	public ResourceInfo create(ResourceInfo info) {
		Resource parent = resourceRepository.findOne(info.getParentId());
		if(parent == null){
			parent = resourceRepository.findByName("根节点");
		}
		Resource resource = new Resource();
		BeanUtils.copyProperties(info, resource);
		parent.addChild(resource);
		info.setId(resourceRepository.save(resource).getId());
		return info;		
	}

	@Override
	public ResourceInfo update(ResourceInfo info) {
		Resource resource = resourceRepository.findOne(info.getId());
		BeanUtils.copyProperties(info, resource);
		return info;
	}

	@Override
	public void delete(Long id) {
		resourceRepository.delete(id);
	}
	/**
	 * (non-Javadoc)
	 *
	 * @see com.coolance.security.rbac.service.ResourceService#move(java.lang.Long, boolean)
	 */
	@Override
	public Long move(Long id, boolean up) {
		Resource resource = resourceRepository.findOne(id);
		int index = resource.getSort();
		List<Resource> children = resource.getParent().getChildren();
		for (int i = 0; i < children.size(); i++) {
			Resource current = children.get(i);
			if(current.getId().equals(id)) {
				if(up){
					if(i != 0) {
						Resource pre = children.get(i - 1);
						resource.setSort(pre.getSort());
						pre.setSort(index);
						resourceRepository.save(pre);
					}
				}else{
					if(i != children.size()-1) {
						Resource next = children.get(i + 1);
						resource.setSort(next.getSort());
						next.setSort(index);
						resourceRepository.save(next);
					}
				}
			}
		}
		resourceRepository.save(resource);
		return resource.getParent().getId();
	}

}
