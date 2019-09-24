/**
 * 
 */
package com.coolance.security.rbac.repository.support;

import org.springframework.core.convert.converter.Converter;

/**
 * @ClassName Domain2InfoConverter
 * @Description 转换器
 * @Author Coolance
 * @Version
 * @Date 2019/9/13 14:27
 */
public interface Domain2InfoConverter<T, I> extends Converter<T, I> {
	
}
