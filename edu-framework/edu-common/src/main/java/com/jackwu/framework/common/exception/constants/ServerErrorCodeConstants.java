package com.jackwu.framework.common.exception.constants;

import com.jackwu.framework.common.exception.ErrorCode;

/**
 * 服务端的通用错误返回码枚举类
 *
 * @author jackwu
 */
public interface ServerErrorCodeConstants {
    // -------------------- 服务端未知错误 -------------------- //

    ErrorCode SERVER_ERROR_UNKNOWN = new ErrorCode("B0000", "系统未知错误!");

    // -------------------- 服务端通用错误 -------------------- //

    ErrorCode SERVER_INTERNAL_ERROR = new ErrorCode("B0500", "系统异常");
}
