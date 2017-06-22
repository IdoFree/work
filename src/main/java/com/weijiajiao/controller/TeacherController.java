package com.weijiajiao.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weijiajiao.configuration.ResponseData;
import com.weijiajiao.dao.dto.TeacherModel;
import com.weijiajiao.logcat.SystemLog;
import com.weijiajiao.model.request.PurchaseTeacherRequest;
import com.weijiajiao.model.request.SearchTeacherRequest;
import com.weijiajiao.service.TeacherService;
import com.weijiajiao.utils.Logger;
import io.swagger.annotations.*;
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
    @Autowired
    TeacherService teacherService;

    @SystemLog
    @GetMapping("/{teacherId}")
    @ApiOperation(value = "老师详情")
    @ApiImplicitParam(paramType = "path", name = "teacherId", dataType = "int", value = "老师的TeacherId", required = true, defaultValue = "1002")
    public ResponseData showTeacher(@Valid @PathVariable Integer teacherId) {
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
        Logger.debug(modelList + "");
        ResponseData data = new ResponseData();
        data.setData(modelList);
        data.setStatus(modelList!=null);
        data.setCode(200);
        return data;
    }

    @SystemLog
    @PostMapping("/purchase")
    @ApiOperation(value = "购买老师")
    public String purchaseTeacher(@ApiParam(name = "purchase_teacher_param", required = true, value = "购买老师") @RequestBody PurchaseTeacherRequest request) {
        return "该方法还未实现";
    }

}

