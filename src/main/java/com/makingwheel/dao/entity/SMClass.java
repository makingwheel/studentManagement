package com.makingwheel.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sm_class")
public class SMClass implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;

	@Column(name = "grade")
	private String grade;
	
	@Column(name = "college")
	private String college;
	
	@Column(name = "class")
	private String smClass;
	
	@Column(name = "status")
	private int status;

	public Long getId() {
		return id;
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

	public int getStatus() {
		return status;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public void setSmClass(String smClass) {
		this.smClass = smClass;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
