package com.makingwheel.model;

import java.util.Optional;

import com.makingwheel.dao.entity.Student;

public interface StudentService {
	
	public Student save(Student student);
	
	public Optional<Student> find(Long id);
	
	public Optional<Student> findByCount(String count);
}
