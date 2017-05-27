package com.weijiajiao.controller;

import com.weijiajiao.model.request.PurchaseTeacherRequest;
import com.weijiajiao.model.request.SearchTeacherRequest;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by junli on 2017/5/25.
 */

@RestController
@RequestMapping("teacher")
@Api(value = "/teacher", description = "老师相关的操作")
public class TeacherController {

    @GetMapping("/{teacherId}")
    @ApiOperation(value = "老师详情")
    @ApiImplicitParam(paramType = "path", name = "teacherId", dataType = "int", value = "老师的TeacherId", required = true, defaultValue = "1002")
    public String showTeacher(@Valid @PathVariable Integer teacherId){
        System.out.println("teacherId:" + teacherId);
        return "老师ID:" + teacherId;
    }


    @PostMapping("/search")
    @ApiOperation(value = "搜索老师")
    public String searchTeacher(@ApiParam(name = "search_parameter" ,required = true, value = "搜索条件") @RequestBody SearchTeacherRequest request){
        return "区域ID:" + request.areaId + "---" + "区域ID:" + request.subjectId;
    }

    @PostMapping("/purchase")
    @ApiOperation(value = "购买老师")
    public String purchaseTeacher(@ApiParam(name = "purchase_teacher_param" ,required = true, value = "购买老师") @RequestBody PurchaseTeacherRequest request){
        return "该方法还未实现";
    }

}

