package com.makingwheel.model.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makingwheel.common.BeanUtils;
import com.makingwheel.common.CollectionUtils;
import com.makingwheel.common.PageResult;
import com.makingwheel.controller.queryParams.TeacherQueryParams;
import com.makingwheel.dao.entity.Teacher;
import com.makingwheel.dao.impl.TeacherDaoImpl;
import com.makingwheel.model.TeacherService;
import com.makingwheel.model.vo.StudentListVo;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherDaoImpl teacherDaoImpl;

	@Override
	public Teacher saveOrUpdate(Teacher teacher) {
		return teacherDaoImpl.save(teacher);
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
		List<StudentListVo> studentListVos = new ArrayList<>();
		for(Object[] result : teacherDaoImpl.list(queryParams)){
			try {
				studentListVos.add(BeanUtils.counstruct(result, StudentListVo.class));
			} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		pageResult.setRows(studentListVos);
		pageResult.setTotal(teacherDaoImpl.queryListTotal(queryParams).intValue());
		return pageResult;
	}

}
