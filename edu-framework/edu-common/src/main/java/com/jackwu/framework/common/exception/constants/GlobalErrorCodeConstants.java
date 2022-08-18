package com.jackwu.framework.common.exception.constants;

import com.jackwu.framework.common.exception.ErrorCode;

/**
 * 全局的通用错误返回码枚举类
 *
 * @author jackwu
 */
public interface GlobalErrorCodeConstants {
    // -------------------- 通用的成功返回码 -------------------- //

    ErrorCode SUCCESS = new ErrorCode("00000", "");

    // -------------------- 用户端未知错误 -------------------- //

    ErrorCode USER_ERROR_UNKNOWN = new ErrorCode("A0000", "用户端未知错误!");

    // -------------------- 用户端通用错误 -------------------- //

    ErrorCode USER_ERROR_BAD_REQUEST = new ErrorCode("A0001", "请求参数不正确");
    ErrorCode USER_ERROR_UNAUTHORIZED = new ErrorCode("A0002", "账号未登录");
    ErrorCode USER_ERROR_FORBIDDEN = new ErrorCode("A0003", "没有该操作权限");
    ErrorCode USER_ERROR_NOT_FOUND = new ErrorCode("A0004", "请求未找到");
    ErrorCode USER_ERROR_METHOD_NOT_ALLOWED = new ErrorCode("A0005", "请求方法不正确");
    ErrorCode USER_ERROR_LOCKED = new ErrorCode("A0006", "请求失败，请稍后重试");
    ErrorCode USER_ERROR_TOO_MANY_REQUESTS = new ErrorCode("A0007", "请求过于频繁，请稍后重试");

    // -------------------- 服务端未知错误 -------------------- //

    ErrorCode SERVER_ERROR_UNKNOWN = new ErrorCode("B0000", "系统未知错误!");

    // -------------------- 服务端通用错误 -------------------- //

    ErrorCode SERVER_INTERNAL_ERROR = new ErrorCode("B0001", "系统异常");

    // -------------------- 第三方服务未知错误 -------------------- //

    ErrorCode THIRD_PARTY_ERROR_UNKNOWN = new ErrorCode("C0000", "第三方未知错误!");
}
