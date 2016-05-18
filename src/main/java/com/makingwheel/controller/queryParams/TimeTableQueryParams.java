package com.makingwheel.controller.queryParams;

import com.makingwheel.common.QueryParameters;

public class TimeTableQueryParams extends QueryParameters {

	private String teacherName;
	
	private String courseName;

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
}
