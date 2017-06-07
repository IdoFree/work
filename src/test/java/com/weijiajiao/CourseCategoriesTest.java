package com.weijiajiao;

import com.weijiajiao.model.response.CourseCategoryResponse;
import com.weijiajiao.model.table.CourseCategory;
import com.weijiajiao.model.table.CourseSubCategory;
import com.weijiajiao.repository.CourseCategoryReponsitory;
import com.weijiajiao.repository.CourseSubCategoryRepository;
import com.weijiajiao.service.ConfigureService;
import com.weijiajiao.utils.Logger;
import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by junli on 2017/6/6.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseCategoriesTest {

    @Autowired
    private ConfigureService configureService;

    @Autowired
    private CourseCategoryReponsitory courseCategoryReponsitory;

    @Autowired
    private CourseSubCategoryRepository courseSubCategoryRepository;

    @Test
    public void testCourseCategory(){
        CourseCategory test = new CourseCategory();
        test.setId(new Long(1));
        CourseCategory[] response = courseCategoryReponsitory.findByParent_Id(new Long(1));


        Assert.assertEquals(5, response.length);

    }

    @Test
    public void testAddSubCategory(){
        Long parentId = new Long(1);
        configSubCategory(parentId);
    }

    private void configSubCategory(Long id){
        CourseCategory[] subs = courseCategoryReponsitory.findByParent_Id(id);
        if (subs.length > 0){
            for (CourseCategory sub:subs) {
                CourseSubCategory item = new CourseSubCategory();
                CourseCategory parent = new CourseCategory();
                parent.setId(id);
                item.setParentCourseCategory(parent);
                item.setSubCourseCategory(sub);
                courseSubCategoryRepository.save(item);

                configSubCategory(sub.getId());
            }
        }
    }

}
