package com.zyy.dao.impl;

import com.zyy.dao.StudentDao;

public class StudentDaoImpl implements StudentDao {

	@Override
	public void findStudent() {
		System.out.println("dao层 sql代码");
	}

}
