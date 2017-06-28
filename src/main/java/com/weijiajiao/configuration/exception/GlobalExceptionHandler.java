package com.weijiajiao.configuration.exception;

import com.weijiajiao.configuration.ResponseCode;
import com.weijiajiao.configuration.ResponseData;
import com.weijiajiao.utils.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by junli on 2017/6/12.
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseData handleException(HttpServletRequest req, Exception e) {
        e.printStackTrace();
        ResponseData response = new ResponseData();
        response.setMessage(e.getMessage());
        Boolean isCustomException = e instanceof CustomException;
        Integer code = isCustomException ? ((CustomException) e).getCode() : ResponseCode.Internal_Server_Error.getCode();
        response.setCode(code);
        response.setData(null);
        response.setStatus(false);
        return response;
    }

}
