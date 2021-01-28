package com.zyy.service.impl;

import com.zyy.dao.StudentDao;
import com.zyy.service.StudentService;

public class StudentServiceImpl implements StudentService {
	private StudentDao studentDao;
	//使用配置文件new对象的时候，要人工写getset方法
	private String user;
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public void findStudent() {
		System.out.println("service层 调用dao 配置文件版本 一般是第三方框架/第三方对象才这样写"+user);
		studentDao.findStudent();
	}

	@Override
	public void findStudentById() {
		
	}

	@Override
	public void addStudent() {
		
	}

	@Override
	public void delStudent() {
		
	}

	@Override
	public void upStudent() {
		
	}
	
}
