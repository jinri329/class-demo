package com.zyy.result;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.zyy.bean.Student;

public class MyRowMapper implements RowMapper<Student>{
	//这个方法会自动循环执行
	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student s = new Student();
		s.setId(rs.getInt("id"));
		s.setName(rs.getString("name"));
		s.setAge(rs.getInt("age"));
		s.setSex(rs.getInt("sex"));
		return s;
	}

}
