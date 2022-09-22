package com.jackwu.framework.security.core.util;

import cn.dev33.satoken.exception.NotLoginException;
import com.jackwu.framework.common.exception.ErrorCode;
import com.jackwu.framework.common.exception.ServiceException;

import static cn.dev33.satoken.exception.NotLoginException.*;
import static com.jackwu.framework.common.exception.constants.GlobalErrorCodeConstants.*;

/**
 * SaToken 的工具类
 *
 * @author jackwu
 */
public class SaTokenUtil {

    /**
     * 根据 {@link NotLoginException} 抛出的异常类型, 转换为 {@link ServiceException}
     *
     * @param e 要转换的 NotLoginException 类型
     * @return 转换后的 ServiceException
     */
    public static ErrorCode getNotLoginExceptionException(NotLoginException e) {
        switch (e.getType()) {
            case NOT_TOKEN:
                return USER_ERROR_NOT_TOKEN;
            case INVALID_TOKEN:
                return USER_ERROR_INVALID_TOKEN;
            case TOKEN_TIMEOUT:
                return USER_ERROR_TOKEN_TIMEOUT;
            case BE_REPLACED:
                return USER_ERROR_BE_REPLACED;
            case KICK_OUT:
                return USER_ERROR_KICK_OUT;
            default:
                return USER_ERROR_NOT_LOGIN;
        }
    }
}
