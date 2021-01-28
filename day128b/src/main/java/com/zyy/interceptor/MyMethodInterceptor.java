package com.zyy.interceptor;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


/**
 * 方法拦截器 类
 * 实现MethodInterceptor
 */
public class MyMethodInterceptor implements MethodInterceptor {

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("这里是对目标类进行增强 这里的方法调用不是用反射");
		Object object = proxy.invokeSuper(obj, args);
		System.out.println("结束");
		return null;
	}

}
