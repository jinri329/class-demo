package com.zyy.dao;

public interface BankDao {
	/**
	 * 
	 * @param name 名字
	 * @param money 金额
	 * 扣除钱
	 */
	void outMoney(String name,int money);
	/**
	 * 
	 * @param name 名字
	 * @param money 金额
	 * 加钱
	 */
	void inMoney(String name,int money);
}
