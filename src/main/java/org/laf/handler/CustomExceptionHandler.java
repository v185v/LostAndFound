package org.laf.handler;

import org.laf.common.exception.ApiException;
import org.laf.common.result.AjaxResult;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Order(50)
public class CustomExceptionHandler {
    @ExceptionHandler(ApiException.class)
    @ResponseBody
    public AjaxResult<Object> handleApiException(ApiException e) {
        return AjaxResult.fail(e.getErrorCode(), e.getErrorMsg());
    }
}
