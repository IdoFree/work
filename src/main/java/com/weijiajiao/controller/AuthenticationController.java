package com.weijiajiao.controller;

import com.weijiajiao.model.request.UniversityTeacherRegisterRequest;
import com.weijiajiao.model.request.WeChatLoginRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by junli on 2017/5/25.
 */

@RestController
@RequestMapping("auth")
@Api(value = "/auth", description = "用户认证相关的操作")
public class AuthenticationController {

    @PostMapping("/wechat_login")
    @ApiOperation(value = "微信登陆操作")
    public String login(@ApiParam(name = "wechat_login_param" ,required = true, value = "微信小程序登陆参数") @RequestBody WeChatLoginRequest request){
        return "该方法还未实现";
    }

    @PostMapping("/teacher/register")
    @ApiOperation(value = "大学生老师注册")
    public String registerUniversityTeacher(@ApiParam(name = "university_teacher_register_param" ,required = true, value = "微信小程序登陆参数") @RequestBody UniversityTeacherRegisterRequest request){
        return "该方法还未实现";
    }

}
