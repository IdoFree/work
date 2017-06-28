package com.weijiajiao.model.response;

import com.weijiajiao.model.table.Course;
import com.weijiajiao.model.table.CourseCategory;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by junli on 2017/6/6.
 */
public class CourseCategoryResponse {
    private Long id;
    private String name;
    private ArrayList<CourseCategoryResponse> subCategories;

    //叶子分类才有课程
    private Course[] subCourses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<CourseCategoryResponse> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(ArrayList<CourseCategoryResponse> subCategories) {
        this.subCategories = subCategories;
    }

    public Course[] getSubCourses() {
        return subCourses;
    }

    public void setSubCourses(Course[] subCourses) {
        this.subCourses = subCourses;
    }

    @Override
    public String toString() {
        return "CourseCategoryResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subCategories=" + subCategories +
                ", subCourses=" + subCourses +
                '}';
    }
}
