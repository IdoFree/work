package com.weijiajiao.model.request;

/**
 * Created by junli on 2017/5/27.
 */
public class PurchaseTeacherRequest {
    Long userId;
    Long teacherId;
    Boolean isUseCoupon;
    Long couponId;

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

    public Boolean getUseCoupon() {
        return isUseCoupon;
    }

    public void setUseCoupon(Boolean useCoupon) {
        isUseCoupon = useCoupon;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }
}
