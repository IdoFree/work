package com.weijiajiao.dao.repository;

import com.weijiajiao.dao.custom.TeacherRepositoryCustom;
import com.weijiajiao.model.table.TeacherInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by fly on 2017/6/2.
 */
public interface TeacherRepository extends JpaRepository<TeacherInfo,Long>,TeacherRepositoryCustom {
}
