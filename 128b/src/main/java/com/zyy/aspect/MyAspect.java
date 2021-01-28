package com.zyy.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
//	前置通知
//	@Before(value="execution(* *..*.*ServiceImpl.add*(..))")
//	public void startLog() {
//		System.out.println("开始记录");
//	}
//	后置通知
//	@After(value="execution(* *..*.*ServiceImpl.add*(..))")
//	public void endLog() {
//		System.out.println("结束记录");
//	}
	//环绕通知
	@Around(value = "execution(* *..*.*ServiceImpl.add*(..))")
	public void login(ProceedingJoinPoint pjp){
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
