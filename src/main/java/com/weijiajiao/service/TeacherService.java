package com.weijiajiao.service;

import com.weijiajiao.cache.impl.TeacherRedisDaoImpl;
import com.weijiajiao.dao.dto.TeacherModel;
import com.weijiajiao.dao.repository.AreaRepository;
import com.weijiajiao.dao.repository.CourseRepository;
import com.weijiajiao.dao.repository.TeacherRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fly on 2017/6/7.
 */
@Component
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private AreaRepository areaRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private TeacherRedisDaoImpl teacherRedisDao;

    public List<TeacherModel> searchTeachers(long areaId, long courseId, int page, int pageSize) {

        String key = "searchTeachers" + areaId + courseId + page + pageSize;
        List<TeacherModel> teacherModelList = teacherRedisDao.getList(key);

        if (teacherModelList != null && teacherModelList.size() != 0) {
            return teacherModelList;
        }
        teacherModelList = teacherRepository.searchTeacherByAreaAndSubject(areaId, courseId, page, pageSize);
        teacherRedisDao.setList(key, teacherModelList);
        return teacherModelList;
    }

    public TeacherModel getTeacherById(long teacherId,boolean hasPhone){
        TeacherModel teacherModel = teacherRedisDao.get(teacherId);
        if (teacherModel != null) {
            return teacherModel;
        }
        teacherModel = TeacherModel.parseFrom(teacherRepository.findOne(teacherId));
        teacherModel.setTeachCourses(courseRepository.queryCourseByTeacherId(teacherId));
        teacherModel.setTeachAreas(areaRepository.queryAreaByTeacherId(teacherId));
        teacherRedisDao.add(teacherModel);
        return teacherModel;
    }
    public TeacherModel getTeacherById(long teacherId) {
        return getTeacherById(teacherId,false);
    }

    public List<TeacherModel> getTeachersWithPhoneByStudentId(long studentId,int page,int pageSize){
        String key = "getTeachersWithPhoneByStudentId" + studentId + page + pageSize;
        List<TeacherModel> teacherModelList = teacherRedisDao.getList(key);

        if (teacherModelList != null && teacherModelList.size() != 0) {
            return teacherModelList;
        }
        teacherModelList = teacherRepository.queryTeacherByStudentId(studentId, page, pageSize);
        teacherRedisDao.setList(key, teacherModelList);
        return teacherModelList;
    }


}
