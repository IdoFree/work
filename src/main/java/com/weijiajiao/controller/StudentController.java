package com.weijiajiao.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.weijiajiao.configuration.ResponseData;
import com.weijiajiao.configuration.WJJConst;
import com.weijiajiao.dao.dto.TeacherModel;
import com.weijiajiao.logcat.SystemLog;
import com.weijiajiao.model.request.ShareTeacherRequest;
import com.weijiajiao.model.request.UpdateUserInfoRequest;
import com.weijiajiao.model.table.PaymentRecord;
import com.weijiajiao.model.table.UserInfo;
import com.weijiajiao.service.PaymentService;
import com.weijiajiao.service.TeacherService;
import com.weijiajiao.service.UserService;
import com.weijiajiao.utils.SessionUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by junli on 2017/5/25.
 */

@RestController
@RequestMapping("student")
@Api(value = "/student", description = "用户相关的操作")
public class StudentController {
    @Autowired
    TeacherService teacherService;

    @Autowired
    UserService userService;
    
    @Autowired
    private PaymentService paymentService;
    

    @SystemLog
    @PostMapping("/profile/update")
    @ApiOperation(value = "更新用户信息")
    public ResponseData updateProfile(@ApiParam(name = "user_info", required = true, value = "用户信息")@RequestBody UpdateUserInfoRequest request){
        UserInfo userInfo = userService.updateUserProfile(request.parseUserInfo());
        ResponseData data = new ResponseData();
        data.setStatus(userInfo!=null);
        data.setData(userInfo);
        return data;
    }

    @SystemLog
    @GetMapping("/purchased_teachers")
    @ApiOperation(value = "购买的老师列表")
    public ResponseData purchasedTeachers(Long studentId, Integer page, Integer pageSize) throws JsonProcessingException {
        List<TeacherModel> modelList = teacherService.getTeachersWithPhoneByStudentId(studentId,page,pageSize);
        ResponseData data = new ResponseData();
        data.setStatus(modelList!=null);
        data.setData(modelList);
        return data;
    }

//    @SystemLog
//    @PostMapping("/share")
//    @ApiOperation(value = "分享操作")
//    public String share(@ApiParam(name = "share_param" ,required = true, value = "分享参数") @RequestBody ShareTeacherRequest request, 
//    		HttpServletRequest httpServletRequest){
//    	SessionUtils.getUserId(httpServletRequest);
//        return "老师Id:" + request.teacherId + "---shareTicket:" + request.shareTicket;
//    }

    @SystemLog
    @GetMapping("/is_purchase_teacher")
    @ApiOperation(value = "是否购买过老师")
    @ApiImplicitParam(name = "teacherId", paramType = "query", dataType = "int", required = true, value = "老师Id")
    public ResponseData isPurchaseTeacher(@RequestParam("teacherId") Long teacherId ,HttpServletRequest request){
    	boolean isPaid = paymentService.teacherWasBuyByStudent(teacherId, (Long) request.getSession().getAttribute(WJJConst.USER_ID));
        return ResponseData.createSuccessResponse(isPaid);
    }

}
