package com.weijiajiao.configuration.exception;

/**
 * Created by junli on 2017/6/12.
 */
public class CustomException extends Exception {

    private static final long serialVersionUID = -5701182284190108797L;

    private Integer code;

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, int code) {
        super(message);
        this.code = code;
    }


}
