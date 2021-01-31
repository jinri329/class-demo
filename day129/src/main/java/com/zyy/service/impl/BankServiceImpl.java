package com.zyy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.zyy.dao.BankDao;
import com.zyy.service.BankService;

/**
 * 
 * 事务管理的注解 可以加在类上和方法上
 * 加在类上就是这个类里面的方法都遵循这个规则
 * 方法上就只有他遵循
 *
 */
@Transactional(isolation=Isolation.DEFAULT)
@Service
public class BankServiceImpl implements BankService {
	@Autowired
	private BankDao bd;
	
	@Override
	public void transfer(String sName, String tName, int money) {
		bd.outMoney(sName, money);
//		int i = 1/0; 
		bd.inMoney(tName, money);
	}

}
