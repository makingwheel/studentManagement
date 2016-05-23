package com.makingwheel.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.makingwheel.common.QueryParameters;
import com.makingwheel.dao.BasicDao;
import com.makingwheel.dao.SMClassDao;
import com.makingwheel.dao.entity.SMClass;

@Repository
public class SMClassDaoImpl extends BasicDao<SMClass>implements SMClassDao {

	@Override
	public List<SMClass> list(QueryParameters queryParams) {
		StringBuffer hql = new StringBuffer("from SMClass ");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		query.setFirstResult(queryParams.getFirstResult());
		query.setMaxResults(queryParams.getLimit());
		@SuppressWarnings("unchecked")
		List<SMClass> smClasses = query.list();
		return smClasses;
	}

	@Override
	public int queryListCount(QueryParameters queryParams) {
		StringBuffer hql = new StringBuffer("select count(*) from SMClass ");
		Long total = (Long) sessionFactory.getCurrentSession().createQuery(hql.toString()).uniqueResult();
		return total.intValue();
	}

	@Override
	public List<SMClass> findNolestThanCurrent(String year) {
		StringBuffer hql = new StringBuffer("from SMClass s ");
		hql.append("where s.grade >= ? ");
		@SuppressWarnings("unchecked")
		List<SMClass> smClasses =  (List<SMClass>) hibernateTemplate.find(hql.toString(), year);
		return smClasses;
	}

	

}
