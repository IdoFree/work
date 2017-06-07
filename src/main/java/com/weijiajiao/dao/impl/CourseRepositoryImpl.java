package com.weijiajiao.dao.impl;

import com.weijiajiao.dao.custom.CourseRepositoryCustom;
import com.weijiajiao.dao.dto.CourseModel;
import com.weijiajiao.logcat.LogUtil;
import com.weijiajiao.model.table.Course;
import com.weijiajiao.model.table.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fly on 2017/6/5.
 */
public class CourseRepositoryImpl implements CourseRepositoryCustom {
    @Autowired
    @PersistenceContext
    private EntityManager entityManager;


    /**
     * id  subject grade gradeid subjectid
     * 11	生物	高一	31	6
     * 8	英语	高一	31	3
     * 10	化学	高一	31	5
     * 7	数学	高一	31	2
     * 13	历史	高一	31	8
     *
     * 暂时只有课程信息，不附带价格信息
     * @param teacherId
     * @return
     */
    @Override
    public List<CourseModel> queryCourseByTeacherId(long teacherId) {
        String courseSql = "SELECT c.* FROM wjj_dev.wjj_teacher_teaching_course AS tc INNER JOIN wjj_dev.core_course AS c " +
                " ON tc.course_id = c.id" +
                " WHERE tc.teacher_id = ?1";

        LogUtil.debug("CourseRepositoryImpl",courseSql.toString());

        Query query = entityManager.createNativeQuery(courseSql);
        query.setParameter(1, teacherId);
        List objectArrayList = query.getResultList();
        if (objectArrayList==null||objectArrayList.size() == 0){
            return null;
        }
        List<CourseModel> retList = new ArrayList();
        for (Object objects:objectArrayList){
            Object[] arrays = (Object[]) objects;
            CourseModel course = new CourseModel();
            course.setId(((BigInteger) arrays[0]).longValue());
            course.setSubjectName((String) arrays[1]);
            course.setGradeName((String) arrays[2]);
            course.setGradeId(((BigInteger) arrays[3]).longValue());
            course.setSubjectId(((BigInteger) arrays[4]).longValue());
            retList.add(course);
        }
        return retList;
    }
}
