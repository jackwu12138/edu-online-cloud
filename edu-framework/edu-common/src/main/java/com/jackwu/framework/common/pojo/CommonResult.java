package com.jackwu.framework.common.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jackwu.framework.common.exception.ErrorCode;
import com.jackwu.framework.common.exception.ServiceException;
import lombok.Data;

import java.io.Serializable;

import static com.jackwu.framework.common.exception.constants.GlobalErrorCodeConstants.SUCCESS;

/**
 * @author jackwu
 */
@Data
public class CommonResult<T> implements Serializable {

    /**
     * 错误码
     *
     * @see ErrorCode#getCode()
     */
    private String code;

    /**
     * 错误提示，用户可阅读
     *
     * @see ErrorCode#getMsg()
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    public static <T> CommonResult<T> success() {
        CommonResult<T> result = new CommonResult<>();
        result.code = SUCCESS.getCode();
        result.msg = SUCCESS.getMsg();
        return result;
    }

    public static <T> CommonResult<T> success(T data) {
        CommonResult<T> result = new CommonResult<>();
        result.code = SUCCESS.getCode();
        result.data = data;
        result.msg = SUCCESS.getMsg();
        return result;
    }

    public static <T> CommonResult<T> error(String code, String message) {
        CommonResult<T> result = new CommonResult<>();
        result.code = code;
        result.msg = message;
        return result;
    }

    public static <T> CommonResult<T> error(ErrorCode errorCode) {
        return error(errorCode.getCode(), errorCode.getMsg());
    }

    // ------------------------- 集成 Exception 体系 ------------------------- //

    /**
     * 请求是否成功
     *
     * @return 成功-true; 失败-false;
     */
    @JsonIgnore
    public boolean isSuccess() {
        return this.code.equals(SUCCESS.getCode());
    }

    /**
     * 判断是否有异常。如果有，则抛出 {@link ServiceException} 异常
     */
    public void checkError() throws ServiceException {
        if (isSuccess()) {
            return;
        }
        // 业务异常
        throw new ServiceException(code, msg);
    }

    /**
     * 判断是否有异常。如果有，则抛出 {@link ServiceException} 异常
     * 如果没有，则返回 {@link #data} 数据
     *
     * @return data
     */
    @JsonIgnore
    public T getCheckedData() {
        checkError();
        return data;
    }
}
