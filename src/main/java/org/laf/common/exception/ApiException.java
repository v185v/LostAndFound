package org.laf.common.exception;

import lombok.Getter;
import org.laf.common.constant.ExceptionEnum;

@Getter
public class ApiException extends RuntimeException {
    /**
     * 错误码
     */
    private final Integer errorCode;
    /**
     * 错误信息
     */
    private final String errorMsg;

    /**
     * 构造函数
     *
     * @param errorCode 错误码
     * @param errorMsg  错误信息
     */
    public ApiException(Integer errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    /**
     * 构造函数
     *
     * @param errorCode 错误码
     * @param errorMsg  错误信息
     * @param cause     异常 cause
     */
    public ApiException(Integer errorCode, String errorMsg, Throwable cause) {
        super(errorMsg, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    /**
     * 构造函数
     *
     * @param exceptionEnum 错误枚举
     */
    public ApiException(ExceptionEnum exceptionEnum) {
        this(exceptionEnum.getErrorCode(),exceptionEnum.getErrorMsg());
    }

    /**
     * 构造函数
     *
     * @param exceptionEnum 错误枚举
     * @param cause         异常 cause
     */
    public ApiException(ExceptionEnum exceptionEnum, Throwable cause) {
        this(exceptionEnum.getErrorCode(),exceptionEnum.getErrorMsg(),cause);
    }
}
