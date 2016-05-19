package com.makingwheel.model.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makingwheel.dao.entity.TeacherCourse;
import com.makingwheel.dao.impl.TeacherCourseDaoImpl;
import com.makingwheel.model.TeacherCourseService;

@Service
public class TeacherCourseServiceImpl implements TeacherCourseService {

	@Autowired
	private TeacherCourseDaoImpl teacherCourseDaoImpl;
	
	@Override
	public void save(TeacherCourse teacherCourse) {
		teacherCourseDaoImpl.save(teacherCourse);
	}
}
