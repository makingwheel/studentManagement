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
@Table(name = "sm_term")
public class Term implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "year")
	private Date year;

	@Column(name = "term")
	private Integer term;

	public Long getId() {
		return id;
	}

	public Date getYear() {
		return year;
	}

	public Integer getTerm() {
		return term;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public void setTerm(Integer term) {
		this.term = term;
	}
}
