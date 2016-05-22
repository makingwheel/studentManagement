package com.makingwheel.dao;

import java.util.List;
import java.util.Optional;

import com.makingwheel.controller.queryParams.StudentQueryParams;
import com.makingwheel.dao.entity.Student;

public interface StudentDao {

	public List<Student> findByCount(String count);
	
	public Optional<List<Student>> findByClassId(Long classId);
	
	public List<Object[]> list(StudentQueryParams queryParams);
	
	public Long queryListTotal(StudentQueryParams queryParams);
}
