package com.weijiajiao.configuration.exception;

import com.weijiajiao.configuration.ResponseCode;

/**
 * Created by junli on 2017/6/12.
 */
public class CouponNotFoundException extends CustomException {

    public CouponNotFoundException() {
        super("找不到对应的优惠劵", ResponseCode.Coupon_Not_Found.getCode());
    }
}
