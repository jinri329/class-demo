package com.zyy.demo1;

import java.lang.reflect.Proxy;

import org.junit.Test;

import com.zyy.service.StudentService;
import com.zyy.service.TService;
import com.zyy.service.impl.StudentServiceImpl;
import com.zyy.service.impl.TServiceImpl;

public class MyTest2 {
	@Test
	public void demo1() {
		StudentService ss = new StudentServiceImpl();
//		StudentService proxyService = (StudentService) Proxy.newProxyInstance(ss.getClass().getClassLoader(), ss.getClass().getInterfaces(), new MyInvocationHandler(ss));
//		proxyService.addStudent();
		/**
		 * 动态代理不会调用到StudentServiceImpl的代码 所以只会执行MyInvocationHandler里面的代码
		 * 但是又要执行StudentServiceImpl的代码的时候，就在MyInvocationHandler里去嗲用
		 */
	
	}
	
	@Test
	public void demo2() {
		TService ts = new TServiceImpl();
		TService proxyTS = (TService) Proxy.newProxyInstance(ts.getClass().getClassLoader(), ts.getClass().getInterfaces(), new MyInvocationHandler(ts));
		proxyTS.findT();
	}
}
