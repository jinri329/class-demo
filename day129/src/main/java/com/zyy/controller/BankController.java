package com.zyy.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zyy.service.BankService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath:applicationContext.xml" }) 
public class BankController {
	@Autowired
	private BankService bs;
	@Test
	public void demo1() {
		bs.transfer("李雷", "韩梅梅", 200);
	}
}
