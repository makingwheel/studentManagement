package com.makingwheel.dao;

import java.util.List;

import com.makingwheel.controller.queryParams.TeacherQueryParams;
import com.makingwheel.dao.entity.Teacher;

public interface TeacherDao {

	public List<Teacher> findByCount(String count);
	
	public List<Object[]> list(TeacherQueryParams queryParams);
	
	public Long queryListTotal(TeacherQueryParams queryParams);
}
