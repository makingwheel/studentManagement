package com.makingwheel.model;

import java.util.Optional;

import com.makingwheel.dao.entity.Term;

public interface TermService {
	
	public Optional<Term> queryCurrentTerm();
}
