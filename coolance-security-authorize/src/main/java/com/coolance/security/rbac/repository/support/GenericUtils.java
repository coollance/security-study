/**
 *
 */
package com.coolance.security.rbac.repository.support;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @ClassName GenericUtils
 * @Description 泛型工具
 * @Author Coolance
 * @Version
 * @Date 2019/9/13 14:27
 */
public class GenericUtils {

    /**
     * 获取目标class的第一个泛型参数的类型
     *
     * @param clazz
     * @return
     */
    public static Class getGenericClass(Class clazz) {
        return getGenericClass(clazz, 0);
    }

    /**
     * 获取目标class的指定位置的泛型参数的类型
     *
     * @param clazz
     * @param index 泛型参数的位置,第一个参数为0
     * @return
     */
    public static Class getGenericClass(Class clazz, int index) {
        Type t = clazz.getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            Type[] params = ((ParameterizedType) t).getActualTypeArguments();
            if (params[index] instanceof ParameterizedType) {
                return ((ParameterizedType) params[index]).getRawType().getClass();
            } else {
                return (Class) params[index];
            }
        }
        throw new RuntimeException("无法获得泛型的类型");
    }

}
