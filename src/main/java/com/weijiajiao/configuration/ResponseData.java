package com.weijiajiao.configuration;

/**
 * Created by junli on 2017/6/12.
 */
public class ResponseData {

    private Boolean status = true;
    private Integer code = 200;
    private String message;
    private Object data;

    public static ResponseData ok(Object data) {
        return new ResponseData(data);
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
