package com.makingwheel.model.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makingwheel.common.CollectionUtils;
import com.makingwheel.dao.entity.Teacher;
import com.makingwheel.dao.impl.TeacherDaoImpl;
import com.makingwheel.model.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherDaoImpl TeacherDaoImpl;

	@Override
	public Teacher save(Teacher teacher) {
		return TeacherDaoImpl.save(teacher);
	}

	@Override
	public Optional<Teacher> find(Long id) {
		return TeacherDaoImpl.find(id);
	}

	@Override
	public Optional<Teacher> findByCount(String count) {
		List<Teacher> teachers = TeacherDaoImpl.findByCount(count);
		return CollectionUtils.validate(teachers) ? Optional.ofNullable(teachers.get(0)) : Optional.ofNullable(null);
	}

}
