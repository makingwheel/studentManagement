package com.makingwheel.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.makingwheel.controller.queryParams.StudentQueryParams;
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

	@Override
	public List<Object[]> list(StudentQueryParams queryParams) {
		StringBuffer sql = new StringBuffer("select s.id, s.count, s.name, s.sex, ");
		sql.append("c.grade, c.college, c.class, s.status ")
		.append("from sm_student s, ")
		.append("sm_class c ")
		.append("where s.class_id = c.id")
		;
		SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
		sqlQuery.setFirstResult(queryParams.getFirstResult());
		sqlQuery.setMaxResults(queryParams.getLimit());
		@SuppressWarnings("unchecked")
		List<Object[]> results = sqlQuery.list();
		return results;
	}

	@Override
	public Long queryListTotal(StudentQueryParams queryParams) {
		StringBuffer sql = new StringBuffer("select count(*) ");
		sql.append("from sm_student s, ")
		.append("sm_class c ")
		.append("where s.class_id = c.id")
		;
		SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
		BigInteger count = (BigInteger) sqlQuery.uniqueResult();
		return count.longValue();
	}

}
