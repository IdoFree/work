package com.weijiajiao.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @GetMapping("/all")
    @ApiOperation(value = "获取所有开通的城市")
    public String fetchAllSubjects(){
        return "还未实现该方法";
    }

}
