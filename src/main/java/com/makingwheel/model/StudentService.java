package com.makingwheel.model;

import java.util.Optional;

import com.makingwheel.common.PageResult;
import com.makingwheel.controller.queryParams.StudentQueryParams;
import com.makingwheel.dao.entity.Student;

public interface StudentService {
	
	public Student saveOrUpdate(Student student);
	
	public Optional<Student> find(Long id);
	
	public Optional<Student> findByCount(String count);
	
	public PageResult list(StudentQueryParams queryParams);
}
