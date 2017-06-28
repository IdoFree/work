package com.weijiajiao.model.request;

/**
 * Created by junli on 2017/6/9.
 */
public class PayRequest {
    private Long userId;
    private Long teacherId;
    private Boolean isUseFreeCoupon;
    private Long couponId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Boolean getUseFreeCoupon() {
        return isUseFreeCoupon;
    }

    public void setUseFreeCoupon(Boolean useFreeCoupon) {
        isUseFreeCoupon = useFreeCoupon;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }
}
