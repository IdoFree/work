package com.weijiajiao.dao.repository;

import com.weijiajiao.dao.custom.CourseRepositoryCustom;
import com.weijiajiao.model.table.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by fly on 2017/6/5.
 */
public interface CourseRepository extends JpaRepository<Course,Long> ,CourseRepositoryCustom {
}
