package com.pinyougou.backend.exception;

import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.common.exception.BaseException;
import com.pinyougou.common.utils.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ljn
 * @date 2019/3/1.
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {

    public static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionAdvice.class);

    @ExceptionHandler(value = BaseException.class)
    public BaseResponse baseExceptionHandler(HttpServletRequest request, BaseException e) {
        BaseResponse response = new BaseResponse();
        response.setErrorMessage(e.getErrorMsg());
        e.printStackTrace();
        LOGGER.error(ExceptionUtil.getPrintStackTrace(e,request));
        return response;
    }

    @ExceptionHandler(value = Exception.class)
    public BaseResponse defaultExceptionHandler(HttpServletRequest request, Exception e) {
        BaseResponse response = new BaseResponse();
        //不让用户看到系统内部的异常
        response.setErrorMessage("系统异常");
        LOGGER.error(ExceptionUtil.getPrintStackTrace(e,request));
        return response;
    }

}
