package com.makingwheel.model.vo;

import com.makingwheel.common.SortField;

public class CourseVo {

	private Long id;

	private String name;

	private String message;

	private String teacherName;

	private Integer week;

	private Integer node;

	private Integer beginWeek;

	private Integer endWeek;

	private String place;
	
	private Double result;
	
	private Long studentTeacherCourseId;

	public Long getId() {
		return id;
	}

	@SortField(value = 1)
	public void setId(Long id) {
		this.id = id;
	}

	@SortField(value = 2)
	public void setName(String name) {
		this.name = name;
	}

	@SortField(value = 3)
	public void setMessage(String message) {
		this.message = message;
	}

	@SortField(value = 4)
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	@SortField(value = 5)
	public void setWeek(Integer week) {
		this.week = week;
	}

	@SortField(value = 6)
	public void setNode(Integer node) {
		this.node = node;
	}
	
	@SortField(value = 7)
	public void setBeginWeek(Integer beginWeek) {
		this.beginWeek = beginWeek;
	}

	@SortField(value = 8)
	public void setEndWeek(Integer endWeek) {
		this.endWeek = endWeek;
	}

	@SortField(value = 9)
	public void setPlace(String place) {
		this.place = place;
	}
	
	@SortField(value = 10)
	public void setResult(Double result) {
		this.result = result;
	}
	
	@SortField(value = 11)
	public void setStudentTeacherCourseId(Long studentTeacherCourseId){
		this.studentTeacherCourseId = studentTeacherCourseId;
	}
	
	public String getName() {
		return name;
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

	public double getResult() {
		return result;
	}
	
	public Long getStudentTeacherCourseId(){
		return studentTeacherCourseId;
	}
}
