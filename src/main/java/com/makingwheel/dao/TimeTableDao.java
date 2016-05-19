package com.makingwheel.dao;

import java.util.List;

import com.makingwheel.controller.queryParams.TimeTableQueryParams;

public interface TimeTableDao {

	public List<Object[]> list(TimeTableQueryParams queryParams);

	public Long queryListCount(TimeTableQueryParams queryParams);

	public Object findByTimeTeacherCourseId(Long timeTeacherCourseId);
}
