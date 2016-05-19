package com.makingwheel.model;

import java.util.Optional;

import com.makingwheel.common.PageResult;
import com.makingwheel.common.QueryParameters;
import com.makingwheel.dao.entity.Term;

public interface TermService {
	
	public Optional<Term> queryCurrentTerm();
	
	public void saveOrUpdate(Term term);
	
	public Optional<Term> find(Long id);
	
	public PageResult list(QueryParameters queryParams);
}
