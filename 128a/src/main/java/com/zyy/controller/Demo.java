package com.zyy.controller;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zyy.service.StudentService;

public class Demo {
	@Test
	public void demo1() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		 StudentService ss= (StudentService) ac.getBean("studentService");
		 ss.addStudent();
	}
}
