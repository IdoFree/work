package com.weijiajiao.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.weijiajiao.configuration.ResponseData;
import com.weijiajiao.configuration.WJJConst;
import com.weijiajiao.logcat.SystemLog;
import com.weijiajiao.model.request.UniversityTeacherRegisterRequest;
import com.weijiajiao.model.request.WeChatLoginRequest;
import com.weijiajiao.model.response.WechatLoginResult;
import com.weijiajiao.model.table.StudentInfo;
import com.weijiajiao.model.table.TeacherInfo;
import com.weijiajiao.model.table.UserInfo;
import com.weijiajiao.service.StudentService;
import com.weijiajiao.service.TeacherService;
import com.weijiajiao.service.UserService;

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
	private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);
	
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
    			log.info("You don't have a account yet, Please sign up first.");
    			return ResponseData.createFailedRespnse("You don't have a account yet, Please sign up first.", ResponseData.FORBIDDEN);
    		}

    		//if yes, login and store the user information to the session for later connection
    		HttpSession session = httpRequest.getSession();
    		session.setAttribute(WJJConst.USER_NAME, userInfo.getNickName());
    		session.setAttribute(WJJConst.USER_ID, userInfo.getId());

		} catch (IOException e) {
			log.error(e.getMessage(),e);
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
		teacherInfo.setMathScore(request.getMathScore());
		teacherInfo.setEnglishScore(request.getEnglishScore());
		teacherInfo.setLizongScore(request.getLizongScore());
		teacherInfo.setWenzongScore(request.getWenzongScore());
		teacherInfo.setMusicScore(request.getMathScore());
		teacherInfo.setSportScore(request.getSportScore());
		teacherInfo.setGaokaoScore(request.getGaokaoScore());
		teacherInfo.setTeacherMajor(request.getTeacherMajor());
		//TODO  create a new teacher , to the get set..
		//this interface is used by the mobile app , the app will send full data
		//then we will create a teacher record in this database for the wechat app

    	teacherService.createTeacher(teacherInfo);
    	log.info("老师 注册成功");
    	return "注册成功";
    }
    

}
