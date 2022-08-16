package com.jackwu.framework.common.exception;

import com.jackwu.framework.common.exception.constants.GlobalErrorCodeConstants;
import com.jackwu.framework.common.exception.constants.ServerErrorCodeConstants;
import com.jackwu.framework.common.exception.constants.ThirdPartyErrorCodeConstants;
import com.jackwu.framework.common.exception.constants.UserErrorCodeConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 业务逻辑错误抛出的 Exception
 *
 * @author jackwu
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ServiceException extends RuntimeException{

    /**
     * 所抛出的错误的错误代码
     *
     * @see GlobalErrorCodeConstants
     * @see UserErrorCodeConstants
     * @see ServerErrorCodeConstants
     * @see ThirdPartyErrorCodeConstants
     */
    private String code;

    /**
     * 所抛出的错误的错误信息
     *
     * @see GlobalErrorCodeConstants
     * @see UserErrorCodeConstants
     * @see ServerErrorCodeConstants
     * @see ThirdPartyErrorCodeConstants
     */
    private String msg;

    /**
     * 私有构造方法
     * 防止被其他地方调用
     */
    private ServiceException(){}

    public ServiceException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }
}
