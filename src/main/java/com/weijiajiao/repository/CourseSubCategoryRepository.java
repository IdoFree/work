package com.weijiajiao.repository;

import com.weijiajiao.model.table.CourseSubCategory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

/**
 * Created by junli on 2017/6/7.
 */
public interface CourseSubCategoryRepository extends CrudRepository<CourseSubCategory, Long> {

//    @Cacheable(value = "parent_course_category_id")
    ArrayList<CourseSubCategory> findByParentCourseCategory_id(Long id);
}
