package com.makingwheel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.makingwheel.dao.BasicDao;
import com.makingwheel.dao.TeacherDao;
import com.makingwheel.dao.entity.Teacher;

@Repository
public class TeacherDaoImpl extends BasicDao<Teacher>implements TeacherDao {

	@Override
	public List<Teacher> findByCount(String count) {
		StringBuffer hql = new StringBuffer("from Teacher t ");
		hql.append("where t.count = ? ");
		@SuppressWarnings("unchecked")
		List<Teacher> teachers = (List<Teacher>) hibernateTemplate.find(hql.toString(), count);
		return teachers;
	}

}
