package com.makingwheel.model;

import java.util.Optional;

import com.makingwheel.common.PageResult;
import com.makingwheel.controller.queryParams.TimeTableQueryParams;
import com.makingwheel.dao.entity.TimeTeacherCourse;
import com.makingwheel.model.vo.TimeTableListVo;

public interface TimeTableService {

	public PageResult list(TimeTableQueryParams queryParams);
	
	public Optional<TimeTableListVo> findByTimeTeacherCourseId(Long timeTeacherCourseId);
	
	public void saveTimeTeacherCourse(TimeTeacherCourse timeTeacherCourse);
}
