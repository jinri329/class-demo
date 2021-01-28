package com.zyy.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.zyy.service.StudentService;

public class MyInvocationHandler implements InvocationHandler {
	private StudentService ss;
	public MyInvocationHandler(StudentService ss) {
		this.ss = ss;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("开始记录");
		method.invoke(ss);
		/*
		 * 这里的ss：
		 * studentClass.newInstance() == new StudentService();
		 * ss类里面有多少方法 就会有多少method对象
		 * 所以method.invoke(类) 就会去执行这个类里面的方法
		 */
		System.out.println("结束记录");
		return null;
	}

}
