/**
 *
 */
package com.coolance.core.validate.code;


import com.coolance.core.properties.SecurityConstants;

/**
 * @ClassName ValidateCodeType
 * @Description 验证码类型枚举
 * @Author Coolance
 * @Version
 * @Date 2019/8/27 22:33
 */
public enum ValidateCodeType {

    /**
     * 短信验证码
     */
    SMS {
        @Override
        public String getParamNameOnValidate() {
            return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_SMS;
        }
    },

    /**
     * 图片验证码
     */
    IMAGE {
        @Override
        public String getParamNameOnValidate() {
            return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_IMAGE;
        }
    };

    /**
     * 校验时从请求中获取的参数的名字
     * @return
     */
    public abstract String getParamNameOnValidate();

}
