package com.makingwheel.dao;

import java.util.List;

import com.makingwheel.controller.queryParams.CourseQueryParameters;
import com.makingwheel.model.vo.CourseVo;

public interface CourseDao {

	public List<CourseVo> queryForStudent(CourseQueryParameters queryParameters);
	
	public Integer queryCountForStudent(CourseQueryParameters queryParameters);
	
	public List<CourseVo> queryForTeacher(CourseQueryParameters queryParameters);
	
	public Integer queryCountForTeacher(CourseQueryParameters queryParameters);
}
