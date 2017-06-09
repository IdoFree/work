package com.weijiajiao;

import com.weijiajiao.service.TeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

/**
 * Created by fly on 2017/6/7.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherServiceTest {
    @Autowired
    TeacherService teacherService;
    @Test
    public void testSearchTeacherWithRedis()throws  Exception{
        Assert.isNull(teacherService.getTeacherById(2),teacherService.getTeacherById(2).toString());
    }

    @Test
    public void testSearchTeachersWithRedis()throws  Exception{
        Assert.hasText("", teacherService.searchTeachers(440105,11,0,10)+"");
    }


}
