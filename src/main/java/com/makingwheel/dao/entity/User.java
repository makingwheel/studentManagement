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
@Table(name = "sm_user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "count")
	private String count;

	@Column(name = "name")
	private String name;

	@Column(name = "type")
	private Integer type;

	@Column(name = "password")
	private String password;

	@Column(name = "status")
	private Integer status;

	@Column(name = "last_login")
	private Date lastLogin;

	@Column(name = "last_modify")
	private Date lastModify;

	public Long getId() {
		return id;
	}

	public String getCount() {
		return count;
	}

	public String getName() {
		return name;
	}

	public Integer getType() {
		return type;
	}

	public String getPassword() {
		return password;
	}

	public Integer getStatus() {
		return status;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public Date getLastModify() {
		return lastModify;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public void setLastModify(Date lastModify) {
		this.lastModify = lastModify;
	}

}
