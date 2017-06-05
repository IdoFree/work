package com.weijiajiao.dao.impl;

import com.weijiajiao.dao.custom.TeacherRepositoryCustom;
import com.weijiajiao.model.table.TeacherInfo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by fly on 2017/6/2.
 */
public class TeacherRepositoryImpl implements TeacherRepositoryCustom {
    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<TeacherInfo> searchTeacherByAreaAndSubject(long areaId, long subjectId) {
        String sql = "select a.id as accountId,a.phone,u.faceUrl,u.realName,u.gender,u.cityID,u.introduce,t.id as teacherId, t.type as teacherType ,t.auditStatus,t.stars,t.careerStartTime,e.university" +
                " from xswy_core.core_account as a" +
                "        inner join xswy_core.core_user_info as u ON a.id=u.accountID " +
                "        inner join xswy_core.core_teacher as t ON a.id = t.accountID" +
                "        inner join xswy_core.core_teacher_educational_info e ON t.id = e.teacherID" +
                "        where t.auditStatus = 3;";
        Query query = entityManager.createNativeQuery(sql);
//        query.setParameter("aid",aid);
        return query.getResultList();
    }
}
