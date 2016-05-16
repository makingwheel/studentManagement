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
@Table(name="sm_student")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "count")
	private String count;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "sex")
	private String sex;
	
	@Column(name = "birthday")
	private Date birthday;

	@Column(name = "nation")
	private String nation;
	
	@Column(name = "place_of_origin")
	private String placeOfOrigin;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "qq")
	private String qq;
	
	@Column(name = "tel")
	private String tel;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "class_id")
	private Long classId;
	
	@Column(name = "degree")
	private String degree;
	
	@Column(name = "status")
	private Integer status;

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

	public Date getBirthday() {
		return birthday;
	}

	public String getNation() {
		return nation;
	}

	public String getPlaceOfOrigin() {
		return placeOfOrigin;
	}

	public String getAddress() {
		return address;
	}

	public String getQq() {
		return qq;
	}

	public String getTel() {
		return tel;
	}

	public String getEmail() {
		return email;
	}

	public Long getClassId() {
		return classId;
	}

	public String getDegree() {
		return degree;
	}

	public Integer getStatus() {
		return status;
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

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public void setPlaceOfOrigin(String placeOfOrigin) {
		this.placeOfOrigin = placeOfOrigin;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
