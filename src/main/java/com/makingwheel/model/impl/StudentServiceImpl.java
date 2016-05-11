package com.makingwheel.model.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makingwheel.common.CollectionUtils;
import com.makingwheel.dao.entity.Student;
import com.makingwheel.dao.impl.StudentDaoImpl;
import com.makingwheel.model.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDaoImpl studentDaoImpl;

	@Override
	public Student save(Student student) {
		return studentDaoImpl.save(student);
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

}
