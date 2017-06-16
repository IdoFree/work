package com.weijiajiao.service;

import com.weijiajiao.cache.impl.TeacherRedisDaoImpl;
import com.weijiajiao.dao.dto.TeacherModel;
import com.weijiajiao.model.table.TeacherInfo;
import com.weijiajiao.repository.AreaRepository;
import com.weijiajiao.repository.CourseRepository;
import com.weijiajiao.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        TeacherInfo teacherInfo = teacherRepository.findOne(teacherId);
        if (teacherInfo == null){
            return null;
        }
        teacherModel = TeacherModel.parseFrom(teacherInfo);
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
