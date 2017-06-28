package com.weijiajiao.model.table;

import org.hibernate.annotations.Table;

import javax.persistence.*;

/**
 * Created by junli on 2017/6/7.
 */

@Entity
@javax.persistence.Table(name = "core_course_sub_category")
public class CourseSubCategory {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private CourseCategory parentCourseCategory;

    @OneToOne
    private CourseCategory subCourseCategory;

    private Integer sort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CourseCategory getParentCourseCategory() {
        return parentCourseCategory;
    }

    public void setParentCourseCategory(CourseCategory parentCourseCategory) {
        this.parentCourseCategory = parentCourseCategory;
    }

    public CourseCategory getSubCourseCategory() {
        return subCourseCategory;
    }

    public void setSubCourseCategory(CourseCategory subCourseCategory) {
        this.subCourseCategory = subCourseCategory;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
