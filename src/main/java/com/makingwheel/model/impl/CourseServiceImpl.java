package com.makingwheel.model.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makingwheel.common.PageResult;
import com.makingwheel.controller.queryParams.CourseQueryParams;
import com.makingwheel.dao.entity.Course;
import com.makingwheel.dao.impl.CourseDaoImpl;
import com.makingwheel.model.CourseService;
import com.makingwheel.model.vo.CourseVo;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDaoImpl courseDaoImpl;

	@Override
	public PageResult queryForStudent(CourseQueryParams queryParameters) {
		PageResult pageResult = new PageResult();
		List<CourseVo> courseVos = courseDaoImpl
				.queryForStudent(queryParameters);
		int count = courseDaoImpl.queryCountForStudent(queryParameters);
		pageResult.setRows(courseVos);
		pageResult.setTotal(count);
		return pageResult;
	}

	@Override
	public void saveOrUpdate(Course course) {
		courseDaoImpl.saveOrUpdate(course);
	}

	@Override
	public Optional<Course> find(Long id) {
		return courseDaoImpl.find(id);
	}

	@Override
	public PageResult list(CourseQueryParams queryParams) {
		// TODO Auto-generated method stub
		return null;
	}

}
