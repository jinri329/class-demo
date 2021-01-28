package com.zyy.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.zyy.servcie.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath:applicationContext.xml" }) 
public class demo {
	@Autowired
	private StudentService ss;
	@Test
	public void demo1() {
		//ApplicationContext ac =new ClassPathXmlApplicationContext("applicationContext.xml");
		//StudentService ss = (StudentService) ac.getBean("studentServiceImpl");
		//但是这里spring对象都不用new 要整合spring和junit的jar包 然后初始一个service类就行了
		ss.addStudent();
	}
}
