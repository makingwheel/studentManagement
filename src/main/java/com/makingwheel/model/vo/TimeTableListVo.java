package com.makingwheel.model.vo;

import com.makingwheel.common.SortField;


public class TimeTableListVo {

	private Long timeTeacherCourseId;

	private Long teacherCourseId;

	private String courseName;

	private String message;

	private String teacherName;

	private Integer week;

	private Integer node;

	private Integer beginWeek;

	private Integer endWeek;

	private String place;

	private String grade;

	private String college;

	private String smClass;
	
	private Long classId;

	public Long getTimeTeacherCourseId() {
		return timeTeacherCourseId;
	}

	public Long getTeacherCourseId() {
		return teacherCourseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public String getMessage() {
		return message;
	}

	public String getTeacherName() {
		return teacherName;
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

	public String getGrade() {
		return grade;
	}

	public String getCollege() {
		return college;
	}

	public String getSmClass() {
		return smClass;
	}

	public Long getClassId() {
		return classId;
	}
	
	@SortField(value = 1)
	public void setTimeTeacherCourseId(Long timeTeacherCourseId) {
		this.timeTeacherCourseId = timeTeacherCourseId;
	}

	@SortField(value = 2)
	public void setTeacherCourseId(Long teacherCourseId) {
		this.teacherCourseId = teacherCourseId;
	}

	@SortField(value = 3)
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@SortField(value = 4)
	public void setMessage(String message) {
		this.message = message;
	}

	@SortField(value = 5)
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	@SortField(value = 6)
	public void setWeek(Integer week) {
		this.week = week;
	}

	@SortField(value = 7)
	public void setNode(Integer node) {
		this.node = node;
	}

	@SortField(value = 8)
	public void setBeginWeek(Integer beginWeek) {
		this.beginWeek = beginWeek;
	}

	@SortField(value = 9)
	public void setEndWeek(Integer endWeek) {
		this.endWeek = endWeek;
	}

	@SortField(value = 10)
	public void setPlace(String place) {
		this.place = place;
	}

	@SortField(value = 11)
	public void setGrade(String grade) {
		this.grade = grade;
	}

	@SortField(value = 12)
	public void setCollege(String college) {
		this.college = college;
	}

	@SortField(value = 13)
	public void setSmClass(String smClass) {
		this.smClass = smClass;
	}

	@SortField(value = 14)
	public void setClassId(Long classId) {
		this.classId = classId;
	}
}
