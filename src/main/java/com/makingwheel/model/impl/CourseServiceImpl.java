package com.makingwheel.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makingwheel.dao.impl.CourseDaoImpl;
import com.makingwheel.model.CourseService;
import com.makingwheel.model.vo.CourseVo;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDaoImpl courseDaoImpl;
	
	@Override
	public List<CourseVo> querybyTerm(Long term) {
		return courseDaoImpl.querybyTerm(term);
//		return null;
	}
	
	

}
