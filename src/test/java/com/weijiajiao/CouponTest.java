package com.weijiajiao;

import com.weijiajiao.configuration.exception.CouponNotFoundException;
import com.weijiajiao.configuration.exception.CustomException;
import com.weijiajiao.model.enum_type.CouponStatus;
import com.weijiajiao.model.table.Coupon;
import com.weijiajiao.service.CouponService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by junli on 2017/6/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CouponTest {

    @Autowired
    private CouponService couponService;

    @Test
    public void TestAddCoupon(){
        couponService.createFreeCoupon(new Long(2));
    }

    @Test
    public void TestUseCoupon(){
        Coupon coupon = couponService.useCoupon(new Long(6));
        Assert.assertEquals(CouponStatus.used, coupon.getStatus());
    }

    @Test
    public void TestAvailableCoupons(){
        Coupon[] coupons = couponService.availableCoupons(new Long(2));
        Assert.assertEquals(2, coupons.length);
    }

    @Test
    public void testExistCoupon(){
        Assert.assertTrue("一定存在", couponService.isCouponExistById(new Long(2)));
    }

    @Test
    public void testInstance(){
        CouponNotFoundException exception = new CouponNotFoundException();
        Boolean isSuccess = exception instanceof CustomException;
        Assert.assertTrue("fuck", isSuccess);
    }

}
