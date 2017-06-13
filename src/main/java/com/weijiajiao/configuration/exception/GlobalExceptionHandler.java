package com.weijiajiao.configuration.exception;

import com.weijiajiao.configuration.ResponseData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by junli on 2017/6/12.
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = CustomException.class)
    @ResponseBody
    public ResponseData handleCustomException(HttpServletRequest req, CustomException e) {
        ResponseData response = new ResponseData();
        response.setMessage(e.getMessage());
        response.setCode(e.getCode());
        response.setData(null);
        response.setStatus(false);
        return response;
    }

}
