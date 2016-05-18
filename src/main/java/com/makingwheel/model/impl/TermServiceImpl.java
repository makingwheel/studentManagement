package com.makingwheel.model.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makingwheel.common.CollectionUtils;
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

}
