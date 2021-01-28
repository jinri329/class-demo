package com.zyy.dao.impl;

import org.springframework.stereotype.Repository;

import com.zyy.dao.StudentDao;
/*
 * repository持久层
 */
@Repository
public class StudnetDaoImpl implements StudentDao {

	@Override
	public void addStudent() {
		System.out.println("dao层 写sql代码");
		
	}

}
