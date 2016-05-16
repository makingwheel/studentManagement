package com.makingwheel.dao;

import java.util.List;

import com.makingwheel.dao.entity.Student;

public interface StudentDao {

	public List<Student> findByCount(String count);
}
