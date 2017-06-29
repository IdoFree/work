package com.weijiajiao.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.weijiajiao.model.table.TeacherInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.weijiajiao.configuration.ResponseData;
import com.weijiajiao.logcat.SystemLog;
import com.weijiajiao.model.enum_type.UserType;
import com.weijiajiao.model.request.UniversityTeacherRegisterRequest;
import com.weijiajiao.model.request.WeChatLoginRequest;
import com.weijiajiao.model.response.WechatLoginResult;
import com.weijiajiao.model.table.StudentInfo;
import com.weijiajiao.model.table.UserInfo;
import com.weijiajiao.service.StudentService;
import com.weijiajiao.service.TeacherService;
import com.weijiajiao.service.UserService;
import com.weijiajiao.utils.HttpUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * Created by junli on 2017/5/25.
 */

@RestController
@RequestMapping("auth")
@Api(value = "/auth", description = "用户认证相关的操作")
public class AuthenticationController {
	private static final String APPID = "";
	private static final String APP_SCRECT = "";

	@Autowired
	private UserService userService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private TeacherService teacherService;

    @PostMapping("/wechat_login")
    @ApiOperation(value = "微信登陆操作")
    @SystemLog
    public ResponseData login(@ApiParam(name = "wechat_login_param" ,required = true, value = "微信小程序登陆参数") 
    		@ModelAttribute("test") WeChatLoginRequest request
    		,HttpServletRequest httpRequest,HttpServletResponse httpResponse){
    	// get the user information  from the database and then store it into the session
    	String code = request.getCode();;
    	String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+APPID+"&secret="+APP_SCRECT+"&js_code="+code+"&grant_type=authorization_code";
    	WechatLoginResult loginResult = null;
    	UserInfo userInfo = null;
    	try {
    		//using the code to get the session_key from the wechat sever;
//    		String resultFromWechat = HttpUtils.httpsGet(url);
    		//fake result for testing
    		String resultFromWechat = "{openid:\"VmTLLUwPiDhhHmXqaleF\",sessionKey:\"lDeuwdrNkakKmnvtMgQA\"}";
    		Gson gson = new Gson();
    		loginResult = gson.fromJson(resultFromWechat, WechatLoginResult.class);
    		//error happen while get session key from wechat
    		if(loginResult.getErrcode()!=null){
    			return ResponseData.createFailedRespnse(loginResult.getErrmsg(), ResponseData.FORBIDDEN);
    		}
    		//get the openid and check if already exist
    		//if no , promote the user to sign up first
    		userInfo = userService.getUserByOpenId(loginResult.getOpenid());
    		if(userInfo == null){
    			httpResponse.sendRedirect("sign_up");
    			return ResponseData.createFailedRespnse("You don't have a account yet, Please sign up first.", ResponseData.FORBIDDEN);
    		}

    		//if yes, login and store the user information to the session for later connection
    		HttpSession session = httpRequest.getSession();
    		session.setAttribute("user", userInfo.getNickName());
    		session.setAttribute("userId", userInfo.getId());

		} catch (IOException e) {
			e.printStackTrace();
			return ResponseData.createFailedRespnse("Server error", ResponseData.INTERNAL_SERVER_ERROR);
		}
    	return ResponseData.createSuccessResponse(null);

    }





    @GetMapping("/login_page")
    @ApiOperation(value = "注册")
    @SystemLog
    public ResponseData loginPage(){
    	return ResponseData.createFailedRespnse("请先登陆", ResponseData.UNAUTHORIZED);
    }

    @PostMapping("/sign_up")
    @ApiOperation(value = "注册")
    @SystemLog
    public ResponseData registerUser(@ApiParam(name = "user_register_param" ,required = true, value = "用户注册登陆参数") 
    @RequestBody StudentInfo studentInfo){
    	studentService.createStudent(studentInfo);
    	if(studentInfo.getId() == null){
    		return ResponseData.createFailedRespnse("用户注册失败", ResponseData.INTERNAL_ERROR);
    		
    	}
    	return ResponseData.createSuccessResponse("用户注册成功");
    }

    @PostMapping("/teacher/register")
    @ApiOperation(value = "大学生老师注册")
    @SystemLog
    public String registerUniversityTeacher(@ApiParam(name = "university_teacher_register_param" ,required = true, value = "微信小程序登陆参数") 
    @RequestBody UniversityTeacherRegisterRequest request){

		TeacherInfo teacherInfo = new TeacherInfo();
		teacherInfo.setChineseScore(request.getChineseScore());
		//TODO  create a new teacher , to the get set..
		//this interface is used by the mobile app , the app will send full data
		//then we will create a teacher record in this database for the wechat app

    	teacherService.createTeacher(teacherInfo);

    	return "该方法还未实现";
    }
    

}
