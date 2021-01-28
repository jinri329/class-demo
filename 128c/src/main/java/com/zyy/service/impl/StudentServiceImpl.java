package com.zyy.service.impl;

import org.springframework.stereotype.Service;

import com.zyy.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Override
	public void addStudent() {
		System.out.println("添加学生");

	}

}
