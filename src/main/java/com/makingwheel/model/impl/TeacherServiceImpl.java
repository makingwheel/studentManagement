package com.makingwheel.model.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makingwheel.common.CollectionUtils;
import com.makingwheel.common.PageResult;
import com.makingwheel.controller.queryParams.TeacherQueryParams;
import com.makingwheel.dao.entity.Teacher;
import com.makingwheel.dao.impl.TeacherDaoImpl;
import com.makingwheel.model.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherDaoImpl teacherDaoImpl;

	@Override
	public Teacher saveOrUpdate(Teacher teacher) {
		return teacherDaoImpl.saveOrUpdate(teacher);
	}

	@Override
	public Optional<Teacher> find(Long id) {
		return teacherDaoImpl.find(id);
	}

	@Override
	public Optional<Teacher> findByCount(String count) {
		List<Teacher> teachers = teacherDaoImpl.findByCount(count);
		return CollectionUtils.validate(teachers) ? Optional.ofNullable(teachers.get(0)) : Optional.ofNullable(null);
	}

	@Override
	public PageResult list(TeacherQueryParams queryParams) {
		PageResult pageResult = new PageResult();
		pageResult.setRows(teacherDaoImpl.list(queryParams));
		pageResult.setTotal(teacherDaoImpl.queryListTotal(queryParams));
		return pageResult;
	}

}
