package com.zyy.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.zyy.service.StudentService;
import com.zyy.service.TService;

public class MyInvocationHandler implements InvocationHandler {
	private StudentService ss;
	private TService ts;
	public MyInvocationHandler(TService ts) {
		//构造方法
		this.ts = ts;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("开始记录");
		method.invoke(ts);
		System.out.println("结束记录");
		return null;
	}

}
