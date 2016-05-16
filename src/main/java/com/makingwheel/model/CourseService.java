package com.makingwheel.model;

import java.util.List;

import com.makingwheel.model.vo.CourseVo;

public interface CourseService {

	public List<CourseVo> querybyTerm(Long term);
}
