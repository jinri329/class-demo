package com.zyy.service;

public interface BankService {
	/**
	 * 
	 * @param sName 转账人
	 * @param tName	收款人
	 * @param money 金额
	 * 转账方法
	 */
	void transfer(String sName,String tName,int money);
}
