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
import com.makingwheel.controller.queryParams.StudentQueryParams;
import com.makingwheel.dao.entity.Student;
import com.makingwheel.dao.impl.StudentDaoImpl;
import com.makingwheel.model.StudentService;
import com.makingwheel.model.vo.StudentListVo;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDaoImpl studentDaoImpl;

	@Override
	public Student saveOrUpdate(Student student) {
		return studentDaoImpl.saveOrUpdate(student);
	}

	@Override
	public Optional<Student> find(Long id) {
		return studentDaoImpl.find(id);
	}

	@Override
	public Optional<Student> findByCount(String count) {
		List<Student> students = studentDaoImpl.findByCount(count);
		return CollectionUtils.validate(students) ? Optional.ofNullable(students.get(0)) : Optional.ofNullable(null);
	}

	@Override
	public PageResult list(StudentQueryParams queryParams) {
		PageResult pageResult = new PageResult();
		List<StudentListVo> studentListVos = new ArrayList<>();
		for(Object[] result : studentDaoImpl.list(queryParams)){
			try {
				studentListVos.add(BeanUtils.counstruct(result, StudentListVo.class));
			} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		pageResult.setRows(studentListVos);
		pageResult.setTotal(studentDaoImpl.queryListTotal(queryParams).intValue());
		return pageResult;
	}

}
