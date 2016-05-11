package com.makingwheel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.makingwheel.dao.BasicDao;
import com.makingwheel.dao.StudentDao;
import com.makingwheel.dao.entity.Student;

@Repository
public class StudentDaoImpl extends BasicDao<Student>implements StudentDao {

	@Override
	public List<Student> findByCount(String count) {
		StringBuffer hql = new StringBuffer("from Student s ");
		hql.append("where s.count = ? ");
		@SuppressWarnings("unchecked")
		List<Student> students = (List<Student>) hibernateTemplate.find(hql.toString(), count);
		return students;
	}

}
