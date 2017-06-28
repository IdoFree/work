package com.weijiajiao.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentRecordTest {
	@Autowired
	private PaymentService paymentService;
	
	@Test
	public void testTeacherWasBuyByStudent(){
		Assert.isTrue(paymentService.teacherWasBuyByStudent(2L, 2L),"no record found");
	}
	
	@Test
	public void testGetRecordByTeacherIdAndStudentId(){
		Assert.notNull(paymentService.getRecordByTeacherIdAndStudentId(2L, 2L),"no record found");
	}
}
