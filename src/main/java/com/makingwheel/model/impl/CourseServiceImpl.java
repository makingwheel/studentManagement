package com.makingwheel.model.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makingwheel.common.BeanUtils;
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
	public PageResult queryForTeacher(CourseQueryParams queryParameters) {
		PageResult pageResult = new PageResult();
		List<CourseVo> courseVos = new ArrayList<>();
		for (Object[] objects : courseDaoImpl.queryForTeacher(queryParameters)) {
			try {
				courseVos.add(BeanUtils.counstruct(objects, CourseVo.class));
			} catch (NoSuchMethodException | SecurityException
					| InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		pageResult.setRows(courseVos);
		pageResult.setTotal(courseDaoImpl.queryCountForTeacher(queryParameters));
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
		PageResult pageResult = new PageResult();
		pageResult.setRows(courseDaoImpl.queryForManager(queryParams));
		pageResult.setTotal(courseDaoImpl.queryCountForManager(queryParams));
		return pageResult;
	}

	@Override
	public void updateResult(Long studentTeacherCourseId, double result) {
		courseDaoImpl.findStudentTeacherCourse(studentTeacherCourseId).ifPresent(x->{
			x.setResult(result);
			courseDaoImpl.updateStudentTeacherCourse(x);
		});
		
	}
}
