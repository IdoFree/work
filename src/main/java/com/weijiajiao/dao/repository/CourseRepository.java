package com.weijiajiao.dao.repository;

import com.weijiajiao.dao.custom.CourseRepositoryCustom;
import com.weijiajiao.model.table.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by fly on 2017/6/5.
 */
public interface CourseRepository extends CrudRepository<Course,Long>,CourseRepositoryCustom {
}
