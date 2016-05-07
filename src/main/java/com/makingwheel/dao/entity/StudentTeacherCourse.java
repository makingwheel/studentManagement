package com.makingwheel.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sm_student_teacher_course")
public class StudentTeacherCourse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "student_id")
	private Long studentId;

	@Column(name = "teacher_course_id")
	private Long teacherCourseId;

	@Column(name = "result")
	private Double result;

	@Column(name = "status")
	private Integer status;

	public Long getId() {
		return id;
	}

	public Long getStudentId() {
		return studentId;
	}

	public Long getTeacherCourseId() {
		return teacherCourseId;
	}

	public Double getResult() {
		return result;
	}

	public Integer getStatus() {
		return status;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public void setTeacherCourseId(Long teacherCourseId) {
		this.teacherCourseId = teacherCourseId;
	}

	public void setResult(Double result) {
		this.result = result;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
