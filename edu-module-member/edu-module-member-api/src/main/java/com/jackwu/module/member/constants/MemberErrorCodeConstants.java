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
    ErrorCode MEMBER_ERROR_USER_ALREADY_UNBLOCKED = new ErrorCode("A4004", "用户已经在解封状态, 不能进行解封操作!");
    ErrorCode MEMBER_ERROR_USER_ALREADY_BANNED = new ErrorCode("A4005", "用户已经在封禁状态, 不能进行封禁操作!");
    ErrorCode MEMBER_ERROR_USER_PASSWORD_ERROR = new ErrorCode("A4006", "用户名或密码错误!");
    ErrorCode MEMBER_ERROR_ADMIN_NOT_FOUND = new ErrorCode("A4010", "管理员账号不存在");
    ErrorCode MEMBER_ERROR_ADMIN_REPEAT = new ErrorCode("A4011", "管理员账号不能重复");
}
