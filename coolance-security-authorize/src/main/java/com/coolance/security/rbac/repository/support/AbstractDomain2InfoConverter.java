/**
 * 
 */
package com.coolance.security.rbac.repository.support;

import org.springframework.beans.BeanUtils;


/**
 * @ClassName AbstractDomain2InfoConverter
 * @Description domain类转换包装类
 * @Author Coolance
 * @Version
 * @Date 2019/9/13 14:27
 */
public abstract class AbstractDomain2InfoConverter<T, I> implements Domain2InfoConverter<T, I> {

	/**
	 * (non-Javadoc)
	 * @see com.coolance.security.rbac.repository.support.Domain2InfoConverter
	 * #convert(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public I convert(T domain) {
		I info = null;
		try {
			Class<I> clazz = GenericUtils.getGenericClass(getClass(), 1);
			info = clazz.newInstance();
			BeanUtils.copyProperties(domain, info);
			doConvert(domain, info);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	/**
	 *	抽象转换方法
	 * @param domain
	 * @param info
	 * @throws Exception
	 */
	protected abstract void doConvert(T domain, I info) throws Exception;

}
