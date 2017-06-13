package com.weijiajiao.model.table;

import com.weijiajiao.model.enum_type.CouponSourceType;
import com.weijiajiao.model.enum_type.CouponStatus;
import com.weijiajiao.model.enum_type.CouponType;
import com.weijiajiao.utils.DateUtils;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by junli on 2017/5/31.
 */
@Entity
@Table(name = "wjj_coupon")
public class Coupon {

    @Id
    @GeneratedValue
    protected Long id;

    @ManyToOne
    private UserInfo user;

    private String title;
    private String detail;

    @Enumerated(EnumType.STRING)
    private CouponType type;

    @Enumerated(EnumType.STRING)
    private CouponSourceType sourceType;

    @Enumerated(EnumType.STRING)
    private CouponStatus status = CouponStatus.unuse;

    private Date beginTime;

    private Date expiredTime;

    private Date updateTime;

    private String manjian;
    private String discount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public CouponType getType() {
        return type;
    }

    public void setType(CouponType type) {
        this.type = type;
    }

    public CouponSourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(CouponSourceType sourceType) {
        this.sourceType = sourceType;
    }

    public CouponStatus getStatus() {
        return status;
    }

    public void setStatus(CouponStatus status) {
        this.status = status;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getManjian() {
        return manjian;
    }

    public void setManjian(String manjian) {
        this.manjian = manjian;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
