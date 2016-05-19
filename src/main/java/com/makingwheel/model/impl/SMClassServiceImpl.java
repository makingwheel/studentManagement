package com.makingwheel.model.impl;

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
		// TODO Auto-generated method stub
		return null;
	}

	

}
