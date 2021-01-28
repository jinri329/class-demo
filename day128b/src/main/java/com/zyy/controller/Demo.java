package com.zyy.controller;

import org.junit.Test;

import com.zyy.interceptor.MyMethodInterceptor;
import com.zyy.service.StudentService;
import com.zyy.service.impl.StudentServiceImpl;

import net.sf.cglib.proxy.Enhancer;

public class Demo {
	@Test
	public void demo1() {
		Enhancer e = new Enhancer();
		//创建Enhancer对象 就类似于proxy类
		e.setSuperclass(StudentServiceImpl.class);
		//设置目标类的字节码文件
		e.setCallback(new MyMethodInterceptor());
		//设置回调函数 调用方法拦截器 类
		StudentService ss  = (StudentService) e.create();
		ss.addStudent();
		ss.findStudent();
	}
}
