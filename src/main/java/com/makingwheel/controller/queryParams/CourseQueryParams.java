package com.makingwheel.controller.queryParams;

import com.makingwheel.common.QueryParameters;

public class CourseQueryParams extends QueryParameters {
	private Long termId;
	
	private Long studentId;
	
	private Long teacherId;

	public Long getTermId() {
		return termId;
	}

	public void setTermId(Long termId) {
		this.termId = termId;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}

	
}
