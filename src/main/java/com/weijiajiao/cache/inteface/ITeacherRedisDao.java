package com.weijiajiao.cache.inteface;

import com.weijiajiao.dao.dto.TeacherModel;

import java.util.List;

/**
 * Created by fly on 2017/6/7.
 */
public interface ITeacherRedisDao {
    boolean add(final TeacherModel teacherModel);

    boolean add(final List<TeacherModel> teacherModels);

    void delete(final Long teacherId);

    TeacherModel get(Long teacherId);

    boolean update(TeacherModel teacherModel);
}
