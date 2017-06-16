package com.weijiajiao.repository;

import com.weijiajiao.model.table.Course;
import com.weijiajiao.model.table.Grade;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by junli on 2017/6/2.
 */
public interface CourseRepository extends CrudRepository<Course, Long> {
   @Cacheable(value = "find_course_by_grade")
   Course[] findByGrade(Grade grade);
}
