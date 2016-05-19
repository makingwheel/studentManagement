package com.makingwheel.model;

import java.util.Optional;

import com.makingwheel.common.PageResult;
import com.makingwheel.controller.queryParams.CourseQueryParams;
import com.makingwheel.dao.entity.Course;

public interface CourseService {

	public PageResult queryForStudent(CourseQueryParams queryParameters);
	
	public void saveOrUpdate(Course course);

	public Optional<Course> find(Long id);
	
	public PageResult list(CourseQueryParams queryParams);
}
