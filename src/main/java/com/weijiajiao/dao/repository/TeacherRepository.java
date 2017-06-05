package com.weijiajiao.dao.repository;

import com.weijiajiao.dao.custom.TeacherRepositoryCustom;
import com.weijiajiao.model.table.TeacherInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by fly on 2017/6/2.
 */
public interface TeacherRepository extends JpaRepository<TeacherInfo,Long>,TeacherRepositoryCustom {
}
