package com.makingwheel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

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

	

}
