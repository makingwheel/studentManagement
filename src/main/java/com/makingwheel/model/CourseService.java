package com.makingwheel.model;

import com.makingwheel.common.PageResult;
import com.makingwheel.controller.queryParams.CourseQueryParams;

public interface CourseService {

	public PageResult queryForStudent(CourseQueryParams queryParameters);
}
