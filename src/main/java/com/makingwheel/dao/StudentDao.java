package com.makingwheel.dao;

import java.util.List;

import com.makingwheel.controller.queryParams.StudentQueryParams;
import com.makingwheel.dao.entity.Student;

public interface StudentDao {

	public List<Student> findByCount(String count);
	
	public List<Object[]> list(StudentQueryParams queryParams);
	
	public Long queryListTotal(StudentQueryParams queryParams);
}
