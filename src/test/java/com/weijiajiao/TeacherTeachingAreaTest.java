package com.weijiajiao;

import com.weijiajiao.model.table.Area;
import com.weijiajiao.model.table.TeacherTeachingArea;
import com.weijiajiao.repository.AreaReponsitory;
import com.weijiajiao.repository.TeacherTeachingAreaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * Created by junli on 2017/6/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherTeachingAreaTest {

    @Autowired
    private TeacherTeachingAreaRepository teacherTeachingAreaRepository;

    @Autowired
    private AreaReponsitory areaReponsitory;

    @Test
    public void TestActivityCity(){
        Long[] ids = areaReponsitory.findActivityCity();
        Area[] areas = areaReponsitory.findByIdIn(ids);
        Arrays.stream(areas).forEach(System.out::println);
    }

}
