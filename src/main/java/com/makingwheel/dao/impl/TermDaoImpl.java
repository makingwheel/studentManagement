package com.makingwheel.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.makingwheel.common.QueryParameters;
import com.makingwheel.dao.BasicDao;
import com.makingwheel.dao.TermDao;
import com.makingwheel.dao.entity.Term;

@Repository
public class TermDaoImpl extends BasicDao<Term>implements TermDao {

	@Override
	public List<Term> queryCurrentTerm(int year, String term) {
		StringBuffer hql = new StringBuffer("from Term t ");
		hql.append("where year(t.year) = ? ")
		.append("and t.term = ? ")
		;
		@SuppressWarnings("unchecked")
		List<Term> terms = (List<Term>) hibernateTemplate.find(hql.toString(), year, term);
		return terms;
	}

	@Override
	public List<Term> list(QueryParameters queryParams) {
		StringBuffer hql = new StringBuffer("from Term ");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		query.setFirstResult(queryParams.getFirstResult());
		query.setMaxResults(queryParams.getLimit());
		@SuppressWarnings("unchecked")
		List<Term> terms = query.list();
		return terms;
	}

	@Override
	public int queryListCount(QueryParameters queryParams) {
		StringBuffer hql = new StringBuffer("select count(*) from Term ");
		Long total = (Long) sessionFactory.getCurrentSession().createQuery(hql.toString()).uniqueResult();
		return total.intValue();
	}

	@Override
	public List<Term> findTermForStudent(Long studentId) {
		StringBuffer hql = new StringBuffer("from Term t where year(t.year) >= ");
		hql.append("(select c.grade from Student s , SMClass c where s.classId = c.id  and s.id = ? ) ");
		@SuppressWarnings("unchecked")
		List<Term> result = (List<Term>) hibernateTemplate.find(hql.toString(), studentId);
		return result;
	}
}
