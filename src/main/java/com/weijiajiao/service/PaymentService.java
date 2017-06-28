package com.weijiajiao.service;

import com.weijiajiao.configuration.WJJConst;
import com.weijiajiao.configuration.exception.CouponNotFoundException;
import com.weijiajiao.model.enum_type.CouponStatus;
import com.weijiajiao.model.request.PayRequest;
import com.weijiajiao.model.response.PaymentInfoResponse;
import com.weijiajiao.model.table.Coupon;
import com.weijiajiao.model.table.PaymentRecord;
import com.weijiajiao.model.table.TeacherInfo;
import com.weijiajiao.model.table.UserInfo;
import com.weijiajiao.repository.PaymentRecordRepository;
import com.weijiajiao.repository.StudentRepository;
import com.weijiajiao.repository.StudentTeacherPayedMappingRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by junli on 2017/6/9.
 */
@Service
public class PaymentService {

    @Autowired
    private CouponService couponService;

    @Autowired
    private PaymentRecordRepository paymentRecordRepository;

    @Autowired
    private StudentTeacherPayedMappingService studentTeacherPayedMappingService;

    @Autowired
    private StudentRepository studentRepository;

    public Boolean pay(PayRequest request) throws CouponNotFoundException {

        PaymentRecord record = new PaymentRecord();
        record.setUser(new UserInfo(request.getUserId()));
        record.setTeacher(new TeacherInfo(request.getTeacherId()));
        Boolean isUseFreeCoupon = request.getUseFreeCoupon();
        record.setUseFreeCoupon(isUseFreeCoupon);
        Float price = isUseFreeCoupon ? 0.0f : WJJConst.CONTACT_TEACHER_PRICE;
        record.setPrice(price);

        if (isUseFreeCoupon){
           Long couponId = request.getCouponId();
           Coupon coupon = couponService.findCouponById(couponId);
           if (coupon != null){
               record.setCoupon(coupon);
               coupon.setStatus(CouponStatus.used);
               coupon.setUpdateTime(new Date());
           } else {
               throw new CouponNotFoundException();
           }
        }

        record.setCreateTime(new Date());
        studentTeacherPayedMappingService.savePayedInfo(getStudentId(request.getUserId()),request.getTeacherId());

        PaymentRecord savedRecord = paymentRecordRepository.save(record);

        return savedRecord != null;
    }

    private Long getStudentId(Long uid) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(uid);
        return studentRepository.findByUserInfo(userInfo).getId();
    }

    public PaymentInfoResponse getPaymentInfo(Long userId){
        PaymentInfoResponse response = new PaymentInfoResponse();
        response.setPrice(WJJConst.CONTACT_TEACHER_PRICE);
        Coupon[] coupons = couponService.availableCoupons(userId);
        response.setCoupons(coupons);
        return response;
    }
    
    
    public boolean teacherWasBuyByStudent(Long teacherid, Long StudentId ){
    	List<PaymentRecord> records = paymentRecordRepository.findUserIdAndTeacherId(teacherid,StudentId);
    	return !records.isEmpty() ;
    }
    
    public List<PaymentRecord>  getRecordByTeacherIdAndStudentId(Long teacherid, Long StudentId ){
    	List<PaymentRecord> records = paymentRecordRepository.findUserIdAndTeacherId(teacherid,StudentId);
    	return records;
    }

}
