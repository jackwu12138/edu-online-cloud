package com.jackwu.framework.common.exception.constants;

import com.jackwu.framework.common.exception.ErrorCode;

/**
 * 用户端的通用错误码枚举类
 *
 * @author jackwu
 */
public interface UserErrorCodeConstants {
    // -------------------- 用户端未知错误 -------------------- //

    ErrorCode USER_ERROR_UNKNOWN = new ErrorCode("A0000", "用户端未知错误!");

    // -------------------- 用户端通用错误 -------------------- //

    ErrorCode USER_ERROR_BAD_REQUEST = new ErrorCode("A0400", "请求参数不正确");
    ErrorCode USER_ERROR_UNAUTHORIZED = new ErrorCode("A0401", "账号未登录");
    ErrorCode USER_ERROR_FORBIDDEN = new ErrorCode("A0403", "没有该操作权限");
    ErrorCode USER_ERROR_NOT_FOUND = new ErrorCode("A0404", "请求未找到");
    ErrorCode USER_ERROR_METHOD_NOT_ALLOWED = new ErrorCode("A0405", "请求方法不正确");
    ErrorCode USER_ERROR_LOCKED = new ErrorCode("A0423", "请求失败，请稍后重试");
    ErrorCode USER_ERROR_TOO_MANY_REQUESTS = new ErrorCode("A0429", "请求过于频繁，请稍后重试");
}
