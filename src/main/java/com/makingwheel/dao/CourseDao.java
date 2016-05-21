package com.makingwheel.dao;

import java.util.List;
import java.util.Optional;

import com.makingwheel.controller.queryParams.CourseQueryParams;
import com.makingwheel.dao.entity.Course;
import com.makingwheel.dao.entity.StudentTeacherCourse;
import com.makingwheel.model.vo.CourseVo;

public interface CourseDao {

	public List<CourseVo> queryForStudent(CourseQueryParams queryParameters);

	public Integer queryCountForStudent(CourseQueryParams queryParameters);

	public List<Object[]> queryForTeacher(CourseQueryParams queryParameters);

	public int queryCountForTeacher(CourseQueryParams queryParameters);
	
	public List<Object[]> queryForTeacherCourse(CourseQueryParams queryParameters);

	public int queryCountForTeacherCourse(CourseQueryParams queryParameters);

	public List<Course> queryForManager(CourseQueryParams queryParameters);

	public int queryCountForManager(CourseQueryParams queryParameters);

	public Optional<StudentTeacherCourse> findStudentTeacherCourse(Long StudentTeacherCourseId);
	
	public void updateStudentTeacherCourse(StudentTeacherCourse studentTeacherCourse);
}
