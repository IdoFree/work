package com.weijiajiao.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by junli on 2017/5/25.
 */

@RestController
@RequestMapping("coupons")
@Api(value = "/coupons", description = "优惠劵相关的操作")
public class CouponController {

    @GetMapping
    @ApiOperation(value = "查看用户的优惠卷")
    public String fetchCoupons(){
       return "该方法还未实现";
    }

    @PostMapping("/purchase")
    public void purchase(){

    }

}
