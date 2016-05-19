package com.makingwheel.dao;

import java.util.List;

import com.makingwheel.controller.queryParams.CourseQueryParams;
import com.makingwheel.dao.entity.Course;
import com.makingwheel.model.vo.CourseVo;

public interface CourseDao {

	public List<CourseVo> queryForStudent(CourseQueryParams queryParameters);

	public Integer queryCountForStudent(CourseQueryParams queryParameters);

	public List<CourseVo> queryForTeacher(CourseQueryParams queryParameters);

	public Integer queryCountForTeacher(CourseQueryParams queryParameters);

	public List<Course> queryForManager(CourseQueryParams queryParameters);

	public int queryCountForManager(CourseQueryParams queryParameters);

}
