package com.makingwheel.dao;

import java.util.List;

import com.makingwheel.dao.entity.Term;

public interface TermDao {

	public List<Term> queryCurrentTerm(int year, String term);
}
