package com.weijiajiao.service;

import com.weijiajiao.model.table.StudentInfo;
import com.weijiajiao.model.table.UserInfo;
import com.weijiajiao.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by fly on 2017/6/23.
 */
@Component
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public StudentInfo getStudentByStuId(Long stuId){
        return studentRepository.findOne(stuId);
    }

    public StudentInfo getStudentByUid(Long uid){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(uid);
        return studentRepository.findByUserInfo(userInfo);
    }
}
