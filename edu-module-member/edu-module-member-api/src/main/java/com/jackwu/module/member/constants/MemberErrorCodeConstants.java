package com.jackwu.module.member.constants;

import com.jackwu.framework.common.exception.ErrorCode;

/**
 * 用户模块的错误码枚举
 *
 * @author jackwu
 */
public interface MemberErrorCodeConstants {

    // -------------------- 用户相关 [ A4000 - A4099 ] -------------------- //

    ErrorCode MEMBER_ERROR_USER_NOT_FOUND = new ErrorCode("A4000", "用户不存在或已被删除");
    ErrorCode MEMBER_ERROR_USERNAME_REPEAT = new ErrorCode("A4001", "用户名不能重复!");
    ErrorCode MEMBER_ERROR_MOBILE_REPEAT = new ErrorCode("A4002", "手机号不能重复!");
    ErrorCode MEMBER_ERROR_EMAIL_REPEAT = new ErrorCode("A4003", "邮箱不能重复!");
}
