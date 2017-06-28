package com.weijiajiao.utils;

import java.io.IOException;

import org.junit.Test;

import com.google.gson.Gson;
import com.weijiajiao.model.response.WechatLoginResult;

public class HttpUtilsTest {
	@Test
	public void testHttpsGet() throws IOException{
		String url = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
		String resultFromWechat = HttpUtils.httpsGet(url);
		Gson gson = new Gson();
		WechatLoginResult result = gson.fromJson(resultFromWechat, WechatLoginResult.class);
		System.out.println(result);
	}
	
	
	@Test
	public void testGson(){
		User user = new User();
		user.setName("ido");
		user.setAge(10);
		user.setGender("man");
		Gson gson = new Gson();
		System.out.println(gson.toJson(user));
	}
	
	
	public static class User{
		private String name;
		private String gender;
		private int age;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		
	}
	
	

}
