package com.makingwheel.model;

import com.makingwheel.common.PageResult;
import com.makingwheel.controller.queryParams.CourseQueryParameters;

public interface CourseService {

	public PageResult querybyTerm(CourseQueryParameters queryParameters);
}
