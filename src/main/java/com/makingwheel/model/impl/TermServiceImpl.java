package com.makingwheel.model.impl;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makingwheel.common.CollectionUtils;
import com.makingwheel.common.PageResult;
import com.makingwheel.common.QueryParameters;
import com.makingwheel.dao.entity.Term;
import com.makingwheel.dao.impl.TermDaoImpl;
import com.makingwheel.model.TermService;

@Service
public class TermServiceImpl implements TermService {

	@Autowired
	private TermDaoImpl termDaoImpl;

	@Override
	public Optional<Term> queryCurrentTerm() {
		LocalDate localDate = LocalDate.now();
		int year = localDate.getYear();
		int month = localDate.getMonth().getValue();
		String term = "";
		if (month < 6) {
			term = "上学期";
		} else {
			term = "下学期";
		}
		List<Term> terms = termDaoImpl.queryCurrentTerm(year, term);
		return CollectionUtils.validate(terms) ? Optional.ofNullable(terms.get(0)) : Optional.ofNullable(null);
	}

	@Override
	public void saveOrUpdate(Term term) {
		termDaoImpl.saveOrUpdate(term);
	}

	@Override
	public Optional<Term> find(Long id) {
		return termDaoImpl.find(id);
	}

	@Override
	public PageResult list(QueryParameters queryParams) {
		PageResult pageResult = new PageResult();
		pageResult.setRows(termDaoImpl.list(queryParams));
		pageResult.setTotal(termDaoImpl.queryListCount(queryParams));
		return pageResult;
	}

	@Override
	public List<Term> findAll() {
		return termDaoImpl.findAll().orElse(Collections.emptyList());
	}

	@Override
	public List<Term> findTremForStudent(Long studentId) {
		return termDaoImpl.findTermForStudent(studentId);
	}

}
