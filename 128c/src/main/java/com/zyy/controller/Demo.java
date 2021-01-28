package com.zyy.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zyy.bean.Student;
import com.zyy.result.MyRowMapper;
import com.zyy.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath:applicationContext.xml" }) 
public class Demo {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//普通版本
	@Test
	public void demo1() {
		/*
		 * spring是一个一站式框架 内置了一个操作数据库的工具
		 * 要先导入mysql 的jar包
		 */
		//1 创建一个Spring数据库的连接池对象
		DriverManagerDataSource dmd = new DriverManagerDataSource();
		//2 配置数据库连接池的基本信息
		dmd.setDriverClassName("com.mysql.jdbc.Driver");
		dmd.setUrl("jdbc:mysql://localhost/student");
		dmd.setUsername("root");
		dmd.setPassword("root");
		//3 创建一个spring的内置对象 这个对象封装了jdbc的基本操作
		JdbcTemplate jt =new JdbcTemplate();
		//4 spring默认封装的操作数据库的对象 实际上也是用到了数据库连接池
		jt.setDataSource(dmd);
		//使用JdbcTemplate对象里面的方法，对数据库进行增删改查操作
		int i = jt.update("INSERT INTO s(name,age,sex) VALUE(?,?,?)", "yq",49,0);
		//但是这是很落后的操作 目前只能这样
		System.out.println(i);
	}
	/**
	 * 查询一个或者所有都是用的query
	 * 	查询获取的都是集合 需要建一个类实现rowmapper 然后创建bean类接收信息
	 * 增删改都是update
	 * 
	 * 传参数都是在后面用逗号隔开直接传进去
	 */
	@Test
	public void add() {
		//高度封装了dao层
		int i = jdbcTemplate.update("INSERT INTO s(name,age,sex) VALUE(?,?,?)", "yq",30,0);
	}
	@Test
	public void del() {
		int i = jdbcTemplate.update("DELETE FROM s WHERE id = ?", 20);
	}
	@Test
	public void update() {
		int i = jdbcTemplate.update("UPDATE s set name=?,age=?,sex=? WHERE id=?", "ss",28,1,16);
	}
	
	@Test
	public void findAll() {
		List<Student> query = jdbcTemplate.query("SELECT * FROM s", new MyRowMapper());
		for (Student student : query) {
			System.out.println(student);
		}
	}
	@Test
	public void findOne() {
		List<Student> query = jdbcTemplate.query("SELECT * FROM s WHERE id=?", new MyRowMapper(),18);
		for (Student student : query) {
			System.out.println(student);
		}
	}
}
