package com.weijiajiao.model.request;

import com.weijiajiao.model.enum_type.UserType;

/**
 * Created by junli on 2017/5/27.
 */

public class WeChatLoginRequest {
    private String code;
    private UserType type;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public UserType getType() {
		return type;
	}
	public void setType(UserType type) {
		this.type = type;
	}
    	
}
