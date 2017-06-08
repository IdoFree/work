package com.weijiajiao.service;

import com.weijiajiao.model.enum_type.CouponSourceType;
import com.weijiajiao.model.enum_type.CouponType;
import com.weijiajiao.model.table.Coupon;
import com.weijiajiao.model.table.UserInfo;
import com.weijiajiao.repository.CouponReponsitory;
import com.weijiajiao.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.zip.DataFormatException;

/**
 * Created by junli on 2017/6/7.
 */

@Service
public class CouponService {

    @Autowired
    private CouponReponsitory couponReponsitory;

    public Coupon createLoginFreeCoupon(Long userId){
        Coupon coupon = new Coupon();
        Date now = new Date();
        coupon.setType(CouponType.free);
        coupon.setSourceType(CouponSourceType.Login);
        coupon.setBeginTime(DateUtils.getStartOfDay(now));
        coupon.setExpiredTime(DateUtils.getEndOfDay(now));
        coupon.setTitle("免费劵");
        coupon.setDetail("每天第一次登陆获取");
        UserInfo user = new UserInfo();
        user.setId(userId);
        coupon.setUser(user);
        couponReponsitory.save(coupon);
        return coupon;
    }


}
