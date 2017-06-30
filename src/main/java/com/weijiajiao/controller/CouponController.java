package com.weijiajiao.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weijiajiao.configuration.ResponseData;
import com.weijiajiao.logcat.SystemLog;
import com.weijiajiao.model.table.Coupon;
import com.weijiajiao.service.CouponService;
import com.weijiajiao.utils.CouponFactory;
import com.weijiajiao.utils.SessionUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Created by junli on 2017/5/25.
 */

@RestController
@RequestMapping("coupons")
@Api(value = "/coupons", description = "优惠劵相关的操作")
public class CouponController {
	
	
	@Autowired
	private CouponService couponService;
	
	
    @GetMapping
    @ApiOperation(value = "查看用户的优惠卷")
    @SystemLog
    public ResponseData fetchCoupons(HttpServletRequest request){
    	Coupon[] availableCoupons = couponService.availableCoupons(SessionUtils.getUserId(request));
        return ResponseData.createSuccessResponse(availableCoupons);
    }

    @PostMapping("/purchase")
    @SystemLog
    public void purchase(){

    }
    
    @GetMapping("/createCoupons")
    @ApiOperation(value = "创建优惠卷")
    @SystemLog
    public ResponseData createCoupons(@RequestParam("method")int methodForGetting , HttpServletRequest request){
    	/**
    	 *  A用户分享了，A就能得到一张券
    	 */
    	//default method
    	if(methodForGetting ==0 ){
    		couponService.createFreeCoupon(CouponFactory.createCouponViaShare(SessionUtils.getUserId(request),methodForGetting));
    		return ResponseData.createSuccessResponse("创建优惠券成功");
    	}
    	
    	return ResponseData.createFailedRespnse("不支持的获取方式", ResponseData.NOT_IMPLEMENTED);
    	
    }

}
