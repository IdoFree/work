package com.weijiajiao.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weijiajiao.dao.dto.TeacherModel;
import com.weijiajiao.logcat.SystemLog;
import com.weijiajiao.model.request.ShareTeacherRequest;
import com.weijiajiao.service.TeacherService;
import com.weijiajiao.utils.Logger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public String purchasedTeachers(Long studentId,int page,int pageSize) throws JsonProcessingException {
        List<TeacherModel> modelList = teacherService.getTeachersWithPhoneByStudentId(studentId,page,pageSize);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(modelList);
        Logger.debug(json + "");
        return json;
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
