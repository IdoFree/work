package com.weijiajiao.model.table;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by junli on 2017/6/9.
 */
@Entity
@Table(name = "wjj_payment_record")
public class PaymentRecord {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private UserInfo user;

    @ManyToOne
    private TeacherInfo teacher;

    private Float price = 0.0f;
    private Boolean isUseFreeCoupon;

    @OneToOne
    private Coupon coupon;

    private Date createTime;

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

    public TeacherInfo getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherInfo teacher) {
        this.teacher = teacher;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Boolean getUseFreeCoupon() {
        return isUseFreeCoupon;
    }

    public void setUseFreeCoupon(Boolean useFreeCoupon) {
        isUseFreeCoupon = useFreeCoupon;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
