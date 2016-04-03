package com.makingwheel.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.makingwheel.dao.StudentDao;
import com.makingwheel.dao.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public Student save(Student student){
		hibernateTemplate.save(student);
		return student;
	}
	
}
