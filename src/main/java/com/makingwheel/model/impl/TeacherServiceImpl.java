package com.makingwheel.model.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makingwheel.common.CollectionUtils;
import com.makingwheel.common.PageResult;
import com.makingwheel.common.enums.UserType;
import com.makingwheel.controller.queryParams.TeacherQueryParams;
import com.makingwheel.dao.entity.Teacher;
import com.makingwheel.dao.entity.User;
import com.makingwheel.dao.impl.TeacherDaoImpl;
import com.makingwheel.dao.impl.UserDaoImpl;
import com.makingwheel.model.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	private static final String DEFAUL_PASSWORD = "123456";
	
	@Autowired
	private TeacherDaoImpl teacherDaoImpl;
	
	@Autowired
	private UserDaoImpl userDaoImpl;

	@Override
	public Teacher saveOrUpdate(Teacher teacher) {
		boolean newOne =  null == teacher.getId();
		teacherDaoImpl.saveOrUpdate(teacher);
		if (newOne) {
			User user = new User();
			user.setCount(teacher.getCount());
			user.setPassword(DEFAUL_PASSWORD);
			user.setType(UserType.TEACHER.getValue());
			user.setStatus(1);
			userDaoImpl.save(user);
		}
		return teacher;
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
