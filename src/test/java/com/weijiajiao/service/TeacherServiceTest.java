package com.weijiajiao.service;

import com.weijiajiao.model.table.Account;
import com.weijiajiao.model.table.TeacherInfo;
import com.weijiajiao.model.table.UserInfo;
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
    
    @Autowired
	private PaymentService paymentService;
    
    @Test
    public void testSearchTeacherWithRedis()throws  Exception{
        Assert.isNull(teacherService.getTeacherById(2),teacherService.getTeacherById(2).toString());
    }

    @Test
    public void testSearchTeachersWithRedis()throws  Exception{
        Assert.hasText("", teacherService.searchTeachers(440105,11,0,10)+"");
    }

    @Test
    public void testQueryTeachersWithPhoneByStudentId()throws  Exception{
        Assert.hasText("", teacherService.getTeachersWithPhoneByStudentId(1,0,10)+"");
    }
    @Test
    public void testCreateTeacher()throws  Exception{
    	TeacherInfo teacher = new TeacherInfo();
    	UserInfo userinfo = new UserInfo();
    	Account account = new Account();
    	account.setName("ido");
    	account.setOpenId("fa3543w5fdasf");
    	account.setPassword("fasdg5234fas");
    	account.setWechatSessionKey("fag352");
    	
    	userinfo.setAccount(account);
    	
    	teacher.setUserInfo(userinfo);
    	teacherService.createTeacher(teacher);
    	Assert.notNull(teacher, "save failed");
    }
    
//    @Test
//    public void testQueryTeacherWichOpenId(){
//    	Assert.hasText("", teacherService.getTeacherWithOpenId("fa3543w5fdasf")+"");
//    }
    
    @Test
	public void testTeacherWasBuyByStudent(){
		Assert.isTrue(paymentService.teacherWasBuyByStudent(2L, 2L),"no record found");
	}




}
