package com.makingwheel.model;

import java.util.Optional;

import com.makingwheel.common.PageResult;
import com.makingwheel.controller.queryParams.TeacherQueryParams;
import com.makingwheel.dao.entity.Teacher;

public interface TeacherService {
	
	public Teacher saveOrUpdate(Teacher teacher);
	
	public Optional<Teacher> find(Long id);
	
	public Optional<Teacher> findByCount(String count);
	
	public PageResult list(TeacherQueryParams queryParams);
}
