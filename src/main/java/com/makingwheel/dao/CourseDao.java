package com.makingwheel.dao;

import java.util.List;

import com.makingwheel.controller.queryParams.CourseQueryParameters;
import com.makingwheel.model.vo.CourseVo;

public interface CourseDao {

	public List<CourseVo> querybyTerm(CourseQueryParameters queryParameters);
	
	public Integer queryCountbyTerm(CourseQueryParameters queryParameters);
}
