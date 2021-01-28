package com.zyy.servcie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zyy.dao.StudentDao;
import com.zyy.servcie.StudentService;

/*
 * Component已经被替换了
 */
@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;
	@Override
	public void addStudent() {
		System.out.println("service层 调用dao 注解版本 三层结构就是用的注解");
		studentDao.addStudent();
	}

}
