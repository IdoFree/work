package com.weijiajiao.service;

import com.weijiajiao.model.enum_type.CouponSourceType;
import com.weijiajiao.model.enum_type.CouponStatus;
import com.weijiajiao.model.enum_type.CouponType;
import com.weijiajiao.model.table.Coupon;
import com.weijiajiao.model.table.UserInfo;
import com.weijiajiao.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by junli on 2017/6/7.
 */

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponReponsitory;

    public Coupon createFreeCoupon(Long userId){
        Coupon coupon = new Coupon();
        coupon.setType(CouponType.free);
        coupon.setSourceType(CouponSourceType.Share);
        coupon.setTitle("免费劵");
        coupon.setDetail("分享获得免费劵");
        coupon.setUser(new UserInfo(userId));
        coupon.setUpdateTime(new Date());
        couponReponsitory.save(coupon);
        return coupon;
    }

    public Coupon useCoupon(Long couponId){
        Coupon coupon = couponReponsitory.findOne(couponId);
        coupon.setStatus(CouponStatus.used);
        coupon.setUpdateTime(new Date());
        couponReponsitory.save(coupon);
        return coupon;
    }

    public Coupon[] availableCoupons(Long userId){
          Coupon[] coupons = couponReponsitory.findByUser_IdAndStatus(userId, CouponStatus.unuse);
          return coupons;
    }

    public Boolean isCouponExistById(Long id){
        return couponReponsitory.existsById(id);
    }

    public Coupon findCouponById(Long id){
        return couponReponsitory.findOne(id);
    }



}
