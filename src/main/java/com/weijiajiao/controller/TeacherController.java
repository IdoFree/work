package com.weijiajiao.controller;

import com.weijiajiao.configuration.ResponseData;
import com.weijiajiao.dao.dto.TeacherModel;
import com.weijiajiao.logcat.SystemLog;
import com.weijiajiao.model.request.CreateTeacherRequest;
import com.weijiajiao.model.request.SearchTeacherRequest;
import com.weijiajiao.model.table.TeacherInfo;
import com.weijiajiao.service.PaymentService;
import com.weijiajiao.service.StudentService;
import com.weijiajiao.service.StudentTeacherPayedMappingService;
import com.weijiajiao.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by junli on 2017/5/25.
 */

@RestController
@RequestMapping("teacher")
@Api(value = "/teacher", description = "老师相关的操作")
public class TeacherController {
    private final  static Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @Autowired
    TeacherService teacherService;
    @Autowired
    PaymentService paymentService;

    @Autowired
    StudentService studentService;

    @Autowired
    StudentTeacherPayedMappingService studentTeacherPayedMappingService;

    @SystemLog
    @GetMapping("/{teacherId}")
    @ApiOperation(value = "老师详情")
    @ApiImplicitParam(paramType = "path", name = "teacherId", dataType = "int", value = "老师的TeacherId", required = true, defaultValue = "3")
    public ResponseData showTeacher(@Valid @PathVariable Integer teacherId) throws Exception {
        // TODO: 2017/6/12 购买过的老师调用 #getTeacherById(long,boolean) 包含phone字段
        TeacherModel model = teacherService.getTeacherById(teacherId);
        ResponseData data = new ResponseData();
        data.setData(model);
        data.setStatus(model != null);
        return data;
    }

    @SystemLog
    @PostMapping("/search")
    @ApiOperation(value = "搜索老师")
    public ResponseData searchTeacher(@ApiParam(name = "search_parameter", required = true, value = "搜索条件") @RequestBody SearchTeacherRequest request) throws Exception {
        List<TeacherModel> modelList = teacherService.searchTeachers(request.areaId, request.subjectId, request.page, request.pageSize);
        logger.debug(modelList + "");
        ResponseData data = new ResponseData();
        data.setData(modelList);
        data.setStatus(modelList != null);
        data.setCode(200);
        return data;
    }

    @PostMapping("/add")
    @ApiOperation(value = "大学生招募接口，App后台调用")
    public ResponseData addTeacher(@RequestBody CreateTeacherRequest request){
        TeacherInfo savedTeacher = teacherService.createTeacher(request.convertToTeacherInfo());
        return ResponseData.createSuccessResponse(savedTeacher);
    }

//    @SystemLog
//    @PostMapping("/purchase")
//    @ApiOperation(value = "购买老师")
//    public ResponseData purchaseTeacher(@ApiParam(name = "purchase_teacher_param", required = true, value = "购买老师") @RequestBody PurchaseTeacherRequest request) {
//        ResponseData data = new ResponseData();
//        try {
//            PayRequest payRequest = new PayRequest();
//            StudentInfo stuInfo = studentService.getStudentByUid(request.getUserId());
//            payRequest.setUserId(request.getUserId());
//            payRequest.setCouponId(request.getCouponId());
//            payRequest.setTeacherId(request.getTeacherId());
//            payRequest.setUseFreeCoupon(request.getUseCoupon());
//            Boolean payResult = paymentService.pay(payRequest);
//            if (payResult) {
//                studentTeacherPayedMappingService.savePayedInfo(stuInfo.getId(), request.getTeacherId());
//            }
//            data.setStatus(payResult);
//            data.setMessage(payResult ? "支付成功" : "支付失败");
//        } catch (CouponNotFoundException e) {
//            e.printStackTrace();
//            data.setStatus(false);
//            data.setMessage("支付失败");
//        }
//        return data;
//    }

}

