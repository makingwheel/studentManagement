package com.makingwheel.model;

import java.util.Optional;

import com.makingwheel.common.PageResult;
import com.makingwheel.common.QueryParameters;
import com.makingwheel.dao.entity.SMClass;

public interface SMClassService {
	
	public void saveOrUpdate(SMClass smClass);
	
	public Optional<SMClass> find(Long id);
	
	public PageResult list(QueryParameters queryParams);
}
