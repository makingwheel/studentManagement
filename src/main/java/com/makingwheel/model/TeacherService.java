package com.makingwheel.model;

import java.util.Optional;

import com.makingwheel.dao.entity.Teacher;

public interface TeacherService {
	
	public Teacher save(Teacher teacher);
	
	public Optional<Teacher> find(Long id);
	
	public Optional<Teacher> findByCount(String count);
}
