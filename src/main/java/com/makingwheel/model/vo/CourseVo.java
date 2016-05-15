package com.makingwheel.model.vo;

import com.makingwheel.common.SortField;

public class CourseVo {

	private Long id;

	private String name;

	// @SortField(value = 3)
	private String message;

	private String teacheName;

	private Integer week;

	private Integer node;

	private Integer beginWeek;

	private Integer endWeek;

	private String place;

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

	public void setMessage(String message) {
		this.message = message;
	}

	public void setTeacheName(String teacheName) {
		this.teacheName = teacheName;
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
	
	public String getName() {
		return name;
	}

	public String getMessage() {
		return message;
	}

	public String getTeacheName() {
		return teacheName;
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

}
