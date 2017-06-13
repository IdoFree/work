package com.weijiajiao.model.response;

import com.weijiajiao.model.table.Coupon;

/**
 * Created by junli on 2017/6/9.
 */
public class PaymentInfoResponse {

    private float price;
    private Coupon[] coupons;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Coupon[] getCoupons() {
        return coupons;
    }

    public void setCoupons(Coupon[] coupons) {
        this.coupons = coupons;
    }

}
