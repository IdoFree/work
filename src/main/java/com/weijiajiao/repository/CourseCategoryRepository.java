package com.weijiajiao.repository;

import com.weijiajiao.model.table.CourseCategory;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by junli on 2017/6/6.
 */
public interface CourseCategoryRepository extends CrudRepository<CourseCategory, Long> {
    CourseCategory[] findByParent(CourseCategory parent);
    CourseCategory[] findByParent_Id(Long parentId);
}
