package com.makingwheel.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.makingwheel.controller.queryParams.TeacherQueryParams;
import com.makingwheel.dao.BasicDao;
import com.makingwheel.dao.TeacherDao;
import com.makingwheel.dao.entity.Teacher;

@Repository
public class TeacherDaoImpl extends BasicDao<Teacher>implements TeacherDao {

	@Override
	public List<Teacher> findByCount(String count) {
		StringBuffer hql = new StringBuffer("from Teacher s ");
		hql.append("where s.count = ? ");
		@SuppressWarnings("unchecked")
		List<Teacher> teachers = (List<Teacher>) hibernateTemplate.find(hql.toString(), count);
		return teachers;
	}

	@Override
	public List<Teacher> list(TeacherQueryParams queryParams) {
		StringBuffer hql = new StringBuffer("from Teacher t ");
		hql.append("where 1=1 ");
		String count = queryParams.getCount();
		String name = queryParams.getName();
		int namePosition = 0;
		if (!StringUtils.isEmpty(count)) {
			hql.append("and t.count = ? ");
			namePosition++;
		}
		if (!StringUtils.isEmpty(name)) hql.append("and t.name = ? ");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		if (!StringUtils.isEmpty(count)) query.setParameter(0, count);
		if (!StringUtils.isEmpty(name)) query.setParameter(namePosition, name);
		query.setFirstResult(queryParams.getFirstResult());
		query.setMaxResults(queryParams.getLimit());
		@SuppressWarnings("unchecked")
		List<Teacher> teachers = query.list();
		return teachers;
	}

	@Override
	public int queryListTotal(TeacherQueryParams queryParams) {
		StringBuffer hql = new StringBuffer(" select count(*) from Teacher t ");
		hql.append("where 1=1 ");
		String count = queryParams.getCount();
		String name = queryParams.getName();
		int namePosition = 0;
		if (!StringUtils.isEmpty(count)) {
			hql.append("and t.count = ? ");
			namePosition++;
		}
		if (!StringUtils.isEmpty(name)) hql.append("and t.name = ? ");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		if (!StringUtils.isEmpty(count)) query.setParameter(0, count);
		if (!StringUtils.isEmpty(name)) query.setParameter(namePosition, name);
		
		Long total = (Long) query.uniqueResult();
		return total.intValue();
	}

}
