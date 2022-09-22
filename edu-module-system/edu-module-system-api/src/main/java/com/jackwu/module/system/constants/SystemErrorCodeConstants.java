package com.jackwu.module.system.constants;

import com.jackwu.framework.common.exception.ErrorCode;

/**
 * 系统模块的错误码枚举
 *
 * @author jackwu
 */
public interface SystemErrorCodeConstants {

    // -------------------- 验证码相关 [ A1000 - A1099 ] -------------------- //

    ErrorCode SYSTEM_ERROR_CAPTCHA_NOT_FOUND = new ErrorCode("A1000", "验证码已过期");
    ErrorCode SYSTEM_ERROR_CAPTCHA_ERROR = new ErrorCode("A1001", "验证码错误");
    ErrorCode SYSTEM_ERROR_NOT_ENABLE = new ErrorCode("A1002", "验证码功能未启用");
}
