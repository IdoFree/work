package com.weijiajiao.configuration;

/**
 * Created by junli on 2017/6/12.
 */
public class ResponseData {
	
	public static final int NOT_FOUND = 404;
	public static final int REDIRECT = 302;
	public static final int INTERNAL_ERROR = 500;
	public static final int UNAUTHORIZED = 401;
	public static final int FORBIDDEN = 403;
	public static final int INTERNAL_SERVER_ERROR = 500;
	public static final int NOT_IMPLEMENTED = 501;
	public static final int REQUEST_TIMEOUT = 408;
	

    private Boolean status = true;
    private Integer code = 200;
    private String message;
    private Object data;

    public static ResponseData createSuccessResponse(Object data) {
        return new ResponseData(data);
    }
    
    public static ResponseData createFailedRespnse(String msg,Integer code){
    	ResponseData response = new ResponseData();
    	response.setMessage(msg);
    	response.setCode(code);
    	response.setStatus(false);
    	return response;
    }

    public ResponseData(Object data) {
        super();
        this.data = data;
    }

    public ResponseData() {
        super();
    }

    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }

}
