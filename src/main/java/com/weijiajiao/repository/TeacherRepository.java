package com.weijiajiao.repository;

import com.weijiajiao.dao.custom.TeacherRepositoryCustom;
import com.weijiajiao.model.table.TeacherInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by fly on 2017/6/2.
 */
public interface TeacherRepository extends CrudRepository<TeacherInfo,Long>,TeacherRepositoryCustom {
    Boolean existsById(Long teacherId);
}
