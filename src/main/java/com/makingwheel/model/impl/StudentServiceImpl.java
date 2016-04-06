package com.makingwheel.model.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makingwheel.dao.entity.Student;
import com.makingwheel.dao.impl.StudentDaoImpl;
import com.makingwheel.model.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDaoImpl studentDaoImpl;
	
	public Student save(Student student) {
		return studentDaoImpl.save(student);
	}

}
