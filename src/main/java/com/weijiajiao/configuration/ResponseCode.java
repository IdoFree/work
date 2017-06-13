package com.weijiajiao.configuration;

/**
 * Created by junli on 2017/6/12.
 */
public enum ResponseCode {

    Teacher_Not_Found(406),
    User_Not_Found(407),
    Coupon_Not_Found(408);

    private Integer code;
    public void setCode(Integer code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }
    private ResponseCode(Integer code) {
        this.code = code;
    }

}
