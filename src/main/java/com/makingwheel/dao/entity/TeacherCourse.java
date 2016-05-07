package com.makingwheel.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sm_teacherd_course")
public class TeacherCourse implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "course_id")
	private Long courseId;
	
	@Column(name = "teacher_id")
	private Long teacherId;
	
	@Column(name = "type")
	private Integer type;
	
	@Column(name = "term_id")
	private Long termId;
	
	@Column(name = "status")
	private Integer status;

	public Long getId() {
		return id;
	}

	public Long getCourseId() {
		return courseId;
	}

	public Long getTeacherId() {
		return teacherId;
	}

	public Integer getType() {
		return type;
	}

	public Long getTermId() {
		return termId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public void setTermId(Long termId) {
		this.termId = termId;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
