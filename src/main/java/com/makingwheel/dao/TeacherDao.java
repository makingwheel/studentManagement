package com.makingwheel.dao;

import java.util.List;

import com.makingwheel.dao.entity.Teacher;

public interface TeacherDao {

	public List<Teacher> findByCount(String count);
}
