package com.weijiajiao.configuration.exception;

import com.weijiajiao.configuration.ResponseCode;

/**
 * Created by junli on 2017/6/12.
 */
public class TeacherNotFoundException extends CustomException {
    private static final long serialVersionUID = -1355046108056594333L;

    public TeacherNotFoundException() {
        super("没有找到该老师", ResponseCode.Teacher_Not_Found.getCode());
    }

}
