package com.weijiajiao.service;

import com.weijiajiao.model.response.CourseCategoryResponse;
import com.weijiajiao.model.table.Area;
import com.weijiajiao.model.table.CourseCategory;
import com.weijiajiao.model.table.CourseSubCategory;
import com.weijiajiao.model.table.Grade;
import com.weijiajiao.repository.AreaRepository;
import com.weijiajiao.repository.CourseCategoryRepository;
import com.weijiajiao.repository.CourseRepository;
import com.weijiajiao.repository.CourseSubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by junli on 2017/6/5.
 */
@Service
public class ConfigureService {

    @Autowired
    private AreaRepository areaReponsitory;

    @Autowired
    private CourseCategoryRepository courseCategoryReponsitory;

    @Autowired
    private CourseSubCategoryRepository courseSubCategoryRepository;

    @Autowired
    private CourseRepository courseReponsitory;

    public Area[] getActivityCity(){
        Long[] ids = areaReponsitory.findActivityCityIds();
        Area[] areas = areaReponsitory.findByIdIn(ids);
        return areas;
    }

    public CourseCategoryResponse getCourseCategories(){
        CourseCategoryResponse response = new CourseCategoryResponse();
        Long rootCategoryId = new Long(1);
        CourseCategory rootCourseCategory = courseCategoryReponsitory.findOne(rootCategoryId);
        response.setId(rootCategoryId);
        response.setName(rootCourseCategory.getCategoryName());
        response.setSubCategories(configSubCategories(response));
        return response;
    }

    private ArrayList<CourseCategoryResponse> configSubCategories(CourseCategoryResponse response){

        ArrayList<CourseCategoryResponse> subResponses = new ArrayList<CourseCategoryResponse>();
        ArrayList<CourseSubCategory> subCategory = courseSubCategoryRepository.findByParentCourseCategory_id(response.getId());
        if (subCategory.size() > 0){
            for (CourseSubCategory item:subCategory) {
                CourseCategoryResponse subResponse = new CourseCategoryResponse();
                Long subCategoryId = item.getSubCourseCategory().getId();
                subResponse.setId(subCategoryId);
                subResponse.setName(item.getSubCourseCategory().getCategoryName());
                subResponse.setSubCategories(configSubCategories(subResponse));
                subResponses.add(subResponse);
            }
        } else {
            Grade grade = courseCategoryReponsitory.findOne(response.getId()).getGrade();
            response.setSubCourses(courseReponsitory.findByGrade(grade));
        }

        return subResponses;

    }



}
