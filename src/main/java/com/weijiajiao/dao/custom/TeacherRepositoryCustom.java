package com.weijiajiao.dao.custom;

import java.util.List;

/**
 * Created by fly on 2017/6/2.
 */
public interface TeacherRepositoryCustom {
    List searchTeacherByAreaAndSubject(long areaId, long subjectId);
}
