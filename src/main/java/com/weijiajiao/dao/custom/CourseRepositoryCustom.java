package com.weijiajiao.dao.custom;

import com.weijiajiao.dao.dto.CourseModel;
import com.weijiajiao.model.table.Course;

import java.util.List;

/**
 * Created by fly on 2017/6/5.
 */
public interface CourseRepositoryCustom {
    List<CourseModel> queryCourseByTeacherId(long teacherId);
}
