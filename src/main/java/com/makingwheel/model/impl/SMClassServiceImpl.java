package com.makingwheel.model.impl;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makingwheel.common.PageResult;
import com.makingwheel.common.QueryParameters;
import com.makingwheel.dao.entity.SMClass;
import com.makingwheel.dao.impl.SMClassDaoImpl;
import com.makingwheel.model.SMClassService;

@Service
public class SMClassServiceImpl implements SMClassService {

	@Autowired
	private SMClassDaoImpl smClassDaoImpl;

	@Override
	public void saveOrUpdate(SMClass smClass) {
		smClassDaoImpl.saveOrUpdate(smClass);
	}

	@Override
	public Optional<SMClass> find(Long id) {
		return smClassDaoImpl.find(id);
	}

	@Override
	public PageResult list(QueryParameters queryParams) {
		PageResult pageResult = new PageResult();
		pageResult.setRows(smClassDaoImpl.list(queryParams));
		pageResult.setTotal(smClassDaoImpl.queryListCount(queryParams));
		return pageResult;
	}

	@Override
	public List<SMClass> findAll() {
		return smClassDaoImpl.findAll().orElse(Collections.emptyList());
	}

	@Override
	public List<SMClass> findNolestThanCurrent() {
		return smClassDaoImpl.findNolestThanCurrent(String.valueOf(LocalDate.now().getYear()));
	}
}
