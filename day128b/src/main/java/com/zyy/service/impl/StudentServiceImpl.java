package com.zyy.service.impl;

import com.zyy.service.StudentService;

/**
 * 目标类
 *不能有实现
 *有公共方法 最终方法
 */
public class StudentServiceImpl implements StudentService{

	@Override
	public void addStudent() {
		System.out.println("添加学生");
		
	}

	@Override
	public void findStudent() {
			System.out.println("删除学生");
	}

	@Override
	public void delStudent() {
	}
	
}
