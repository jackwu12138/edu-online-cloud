package com.jackwu.framework.common.exception.constants;

import com.jackwu.framework.common.exception.ErrorCode;

/**
 * 第三方服务的通用错误码枚举类
 *
 * @author jackwu
 */
public interface ThirdPartyErrorCodeConstants {
    // -------------------- 第三方服务通用错误 -------------------- //

    ErrorCode THIRD_PARTY_ERROR_UNKNOWN = new ErrorCode("A0000", "用户端未知错误!");
}
