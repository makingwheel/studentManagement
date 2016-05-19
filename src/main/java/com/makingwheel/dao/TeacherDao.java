package com.makingwheel.dao;

import java.util.List;

import com.makingwheel.controller.queryParams.TeacherQueryParams;
import com.makingwheel.dao.entity.Teacher;

public interface TeacherDao {

	public List<Teacher> findByCount(String count);
	
	public List<Teacher> list(TeacherQueryParams queryParams);
	
	public int queryListTotal(TeacherQueryParams queryParams);
}
