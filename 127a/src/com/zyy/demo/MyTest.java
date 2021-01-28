package com.zyy.demo;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

import com.zyy.service.StudentService;
import com.zyy.service.impl.StudentServiceImpl;

public class MyTest {
	//动态代理
	@Test
	public void demo1() {
		StudentService ss = new StudentServiceImpl();
		StudentService proxyStudent = (StudentService) Proxy.newProxyInstance(ss.getClass().getClassLoader(), ss.getClass().getInterfaces(), new MyInvocationHandler(ss));
		proxyStudent.addStudent();
	}
	//反射
	@Test
	public void demo2() {
		try {
			Class studentClass = Class.forName("com.zyy.service.impl.StudentServiceImpl");
			Object newInstance = studentClass.newInstance();
			Method m = studentClass.getMethod("addStudent");
			m.setAccessible(true);
			m.invoke(newInstance);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
