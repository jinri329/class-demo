package com.zyy.demo1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class MyTest {
	@Test
	public void demo1() {
		/**
		 * 反射
		 * 以前我们是new创建对象的
		 * 但是spring没有new
		 * 因为框架都使用了反射
		 * 反射可以不通过new对象，而且可以调用这个对象里面所有的方法
		 * 私有的公共的 有参无参都可以调用
		 * 因为万物皆对象 任何一个.java文件都会被编译成.calss文件
		 * 而.class文件也是一种对象 Class类
		 * 
		 */
		try {
			//传入一个类的全类名 得到这个类的class类
			Class studentClass = Class.forName("com.zyy.demo1.Student");
			/**
			 * 反射的核心：
			 * 1 	得到一个对象的Class对象
			 * 2  	使用Class对象里面的方法调用构造方法来创建对象
			 * 	studentClass.newInstance(); 就等价于new 类名();
			 */
			Object ni = studentClass.newInstance();//就去调用无参构造
			/**
			 * 以前是对象名.属性名/方法名调用方法调用属性
			 * 使用反射之后，用Class类名.getField就可以获取属性
			 * 且私有的属性也可以访问
			 */
			Field field = studentClass.getField("age");
			/**
			 * getInt(obj) 里面的obj就是那个对象 
			 * Object ni 就等价于 Student s
			 */
			System.out.println(field.getInt(ni));

			/**
			 * 获取私有的属性 方法：
			 * studentClass.getDeclaredField
			 * 并且开启暴力访问模式 
			 * setAccessible(true)
			 * 
			 * 引用数据类型的获取 直接用get
			 * 基本数据类型的获取 就get对应类型
			 * 
			 */
			Field field2 = studentClass.getDeclaredField("name");
			field2.setAccessible(true);
			System.out.println(field2.get(ni));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Test
	public void demo2(){
		try {
			Class studentClass = Class.forName("com.zyy.demo1.Student");
			Object ni = studentClass.newInstance();
			/*
			 * 	public void show() {
					System.out.println("公共的普通方法");
				}
				private void show2(int i) {
					System.out.println("我是私有的普通有参方法");
				}	
			 */
			//方法名称，。。。代表任意个数(可以不写)
			Method m = studentClass.getMethod("show");
			
			/**
			 * 以前是对象.方法名
			 * 现在是class对象.getMethod()获取方法对象类
			 * 然后使用方法对象类.invoke()  调用指定方法
			 */
			m.invoke(ni);
			//无参数的方法就第二个不用写参数 invoke(   ,     )
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void demo3() {
		try {
			Class studentClass = Class.forName("com.zyy.demo1.Student");
			Object ni = studentClass.newInstance();
			/**
			 * 私有方法的调用加上Declared才行
			 */
			Method m = studentClass.getDeclaredMethod("show2",int.class);
			//因为这个方法参数的类型是int 所以就int.class
			m.setAccessible(true);
			//只要是访问私有的方法/属性都需要开启访问模式
			m.invoke(ni,10);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
