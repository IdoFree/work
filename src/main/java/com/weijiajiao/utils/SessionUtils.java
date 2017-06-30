package com.weijiajiao.utils;

import javax.servlet.http.HttpServletRequest;

import com.weijiajiao.configuration.WJJConst;

public class SessionUtils {
	public static Long getUserId(HttpServletRequest request){
		return (Long) request.getSession().getAttribute(WJJConst.USER_ID);
	}

}
