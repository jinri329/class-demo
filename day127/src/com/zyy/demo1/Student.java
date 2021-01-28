package com.zyy.demo1;

public class Student {
	public int age = 26;
	private String name = "jinri";
	public Student() {
		System.out.println("我是无参构造 公共访问规则");
	}
	private Student(int i) {
		System.out.println("我是私有的有参构造"+i);
	}
	public void show() {
		System.out.println("公共的普通方法");
	}
	private void show2(int i) {
		System.out.println("我是私有的普通有参方法"+i);
	}
}
