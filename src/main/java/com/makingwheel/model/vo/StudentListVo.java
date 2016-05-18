package com.makingwheel.model.vo;

import com.makingwheel.common.SortField;

public class StudentListVo {

	private Long id;

	private String count;

	private String name;

	private String sex;

	private String grade;

	private String college;

	private String smClass;

	private String classInfo;

	private Integer status;


	@SortField(value=1)
	public void setId(Long id) {
		this.id = id;
	}

	@SortField(value=2)
	public void setCount(String count) {
		this.count = count;
	}

	@SortField(value=3)
	public void setName(String name) {
		this.name = name;
	}

	@SortField(value=4)
	public void setSex(String sex) {
		this.sex = sex;
	}

	@SortField(value=5)
	public void setGrade(String grade) {
		this.grade = grade;
	}

	@SortField(value=6)
	public void setCollege(String college) {
		this.college = college;
	}

	@SortField(value=7)
	public void setSmClass(String smClass) {
		this.smClass = smClass;
	}

	public void setClassInfo(String classInfo) {
		this.classInfo = classInfo;
	}

	@SortField(value=8)
	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public String getCount() {
		return count;
	}

	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
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

	public String getClassInfo() {
		return classInfo;
	}

	public Integer getStatus() {
		return status;
	}
}
