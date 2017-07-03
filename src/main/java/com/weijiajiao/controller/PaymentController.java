package com.weijiajiao.controller;

import com.weijiajiao.configuration.ResponseData;
import com.weijiajiao.configuration.WJJConst;
import com.weijiajiao.configuration.exception.CouponNotFoundException;
import com.weijiajiao.configuration.exception.TeacherNotFoundException;
import com.weijiajiao.logcat.SystemLog;
import com.weijiajiao.model.request.PayRequest;
import com.weijiajiao.model.response.PaymentInfoResponse;
import com.weijiajiao.model.table.PaymentRecord;
import com.weijiajiao.model.table.TeacherInfo;
import com.weijiajiao.model.table.UserInfo;
import com.weijiajiao.repository.PaymentRecordRepository;
import com.weijiajiao.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by junli on 2017/6/9.
 */

@RestController
@RequestMapping("payment")
@Api(value = "/payment", description = "支付相关的操作")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


//    @GetMapping
//    @ApiOperation(value = "支付信息，包括价格和免费劵")
//    @SystemLog
//    public PaymentInfoResponse getPaymentInfo(@RequestParam("userId") Long userId) {
//        return paymentService.getPaymentInfo(userId);
//    }

    @PostMapping("/pay")
    @ApiOperation(value = "支付老师联系方式")
    public ResponseData pay(@RequestBody PayRequest request) throws CouponNotFoundException {
    	//TODO need to implement the wechat payment method
       Boolean isSuccess = paymentService.pay(request);
       String message = isSuccess ? "支付成功" : "支付失败";
       ResponseData response = new ResponseData();
       response.setStatus(isSuccess);
       response.setMessage(message);
       return response;
    }
    
    @PostMapping("/wechat_pay")
    @ApiOperation(value = "发起微信统一下单")
    public ResponseData payForWechat(@RequestBody PayRequest request) throws CouponNotFoundException {
    	//TODO need to implement the wechat payment method
    	Boolean isSuccess = paymentService.pay(request);
    	String message = isSuccess ? "支付成功" : "支付失败";
    	ResponseData response = new ResponseData();
    	response.setStatus(isSuccess);
    	response.setMessage(message);
    	return response;
    }
    
    
    

}
