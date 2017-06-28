package com.weijiajiao.service;

import com.weijiajiao.model.request.PurchaseTeacherRequest;
import com.weijiajiao.model.table.StudentTeacherPayedMapping;
import com.weijiajiao.repository.StudentRepository;
import com.weijiajiao.repository.StudentTeacherPayedMappingRepository;
import com.weijiajiao.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by fly on 2017/6/23.
 */
@Component
public class StudentTeacherPayedMappingService {
    @Autowired
    StudentTeacherPayedMappingRepository repository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    public void savePayedInfo(Long stuId,Long tId){
        StudentTeacherPayedMapping mapping = new StudentTeacherPayedMapping();
        mapping.setCreateTime(new Date());
        mapping.setStudent(studentRepository.findOne(stuId));
        mapping.setTeacher(teacherRepository.findOne(tId));
        repository.save(mapping);
    }
}
