package com.weijiajiao.controller;

import com.weijiajiao.logcat.SystemLog;
import com.weijiajiao.model.response.CourseCategoryResponse;
import com.weijiajiao.service.ConfigureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by junli on 2017/5/25.
 */

@RestController
@RequestMapping("subjects")
@Api(value = "/subjects", description = "科目相关的操作")
public class SubjectController {

    @Autowired
    private ConfigureService configureService;

    @SystemLog
    @GetMapping("/categories")
    @ApiOperation(value = "获取科目分类")
    public CourseCategoryResponse fetchAllSubjects(){
        return configureService.getCourseCategories();
    }

}
