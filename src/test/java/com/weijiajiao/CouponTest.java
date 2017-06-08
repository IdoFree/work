package com.weijiajiao;

import com.weijiajiao.service.CouponService;
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
        couponService.createLoginFreeCoupon(new Long(3));
    }

}
