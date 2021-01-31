package com.zyy.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zyy.dao.BankDao;

@Repository
public class BankDaoImpl implements BankDao {
	@Autowired
	JdbcTemplate jt;
	@Override
	public void outMoney(String name, int money) {
		int i = jt.update("UPDATE bank SET money=money-? WHERE username = ?",money,name);
	}

	@Override
	public void inMoney(String name, int money) {
		int i = jt.update("UPDATE bank SET money=money+? WHERE username = ?",money,name);
	}

}
