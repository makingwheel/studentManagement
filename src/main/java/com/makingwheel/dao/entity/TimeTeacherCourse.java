package com.makingwheel.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sm_time_teacher_course")
public class TimeTeacherCourse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "teacher_course_id")
	private Long teacherCourseId;

	@Column(name = "week")
	private Integer week;

	@Column(name = "node")
	private Integer node;

	@Column(name = "begin_week")
	private Integer beginWeek;

	@Column(name = "end_week")
	private Integer endWeek;

	@Column(name = "place")
	private String place;

	@Column(name = "status")
	private Integer status;

	public Long getId() {
		return id;
	}

	public Long getTeacherCourseId() {
		return teacherCourseId;
	}

	public Integer getWeek() {
		return week;
	}

	public Integer getNode() {
		return node;
	}

	public Integer getBeginWeek() {
		return beginWeek;
	}

	public Integer getEndWeek() {
		return endWeek;
	}

	public String getPlace() {
		return place;
	}

	public Integer getStatus() {
		return status;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTeacherCourseId(Long teacherCourseId) {
		this.teacherCourseId = teacherCourseId;
	}

	public void setWeek(Integer week) {
		this.week = week;
	}

	public void setNode(Integer node) {
		this.node = node;
	}

	public void setBeginWeek(Integer beginWeek) {
		this.beginWeek = beginWeek;
	}

	public void setEndWeek(Integer endWeek) {
		this.endWeek = endWeek;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
