package com.makingwheel.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sm_notice")
public class Notice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "count_id")
	private Long countId;

	@Column(name = "title")
	private String title;
	
	@Column(name = "message")
	private String message;

	@Column(name = "modify_date")
	private Date modifyDate;

	@Column(name = "status")
	private Integer status;

	public Long getId() {
		return id;
	}

	public Long getCountId() {
		return countId;
	}

	public String getTitle() {
		return title;
	}

	public String getMessage() {
		return message;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCountId(Long countId) {
		this.countId = countId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
