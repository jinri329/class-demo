package com.zyy.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	public void startLog() {
		System.out.println("开始记录");
	}
	public void endLog() {
		System.out.println("结束记录");
	}

	//用于环绕通知的方法
	public void login(ProceedingJoinPoint pjp){
		//类似于动态代理
		System.out.println("开始记录日志");
		try {
			//类似于method.invoke()方法
			pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("提交日志");

	}
}
