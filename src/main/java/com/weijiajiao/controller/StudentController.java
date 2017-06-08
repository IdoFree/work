package com.weijiajiao.controller;

import com.weijiajiao.logcat.SystemLog;
import com.weijiajiao.model.request.ShareTeacherRequest;
import com.weijiajiao.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by junli on 2017/5/25.
 */

@RestController
@RequestMapping("student")
@Api(value = "/student", description = "用户相关的操作")
public class StudentController {
    @Autowired
    TeacherService teacherService;
    @SystemLog
    @PostMapping("/profile/update")
    @ApiOperation(value = "更新用户信息")
    public String updateProfile(){
        return "该方法还未实现";
    }

    @SystemLog
    @GetMapping("/purchased_teachers")
    @ApiOperation(value = "购买的老师列表")
    public String purchasedTeachers(){

        return "该方法还未实现";
    }

    @SystemLog
    @PostMapping("/share")
    @ApiOperation(value = "分享操作")
    public String share(@ApiParam(name = "share_param" ,required = true, value = "分享参数") @RequestBody ShareTeacherRequest request){
        return "老师Id:" + request.teacherId + "---shareTicket:" + request.shareTicket;
    }

    @SystemLog
    @GetMapping("/is_purchase_teacher")
    @ApiOperation(value = "是否购买过老师")
    @ApiImplicitParam(name = "teacherId", paramType = "query", dataType = "int", required = true, value = "老师Id")
    public String isPurchaseTeacher(@RequestParam("teacherId") Integer teacherId ){
        return "老师Id:" + teacherId;
    }

}
