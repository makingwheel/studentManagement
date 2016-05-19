package com.makingwheel.dao;

import java.util.List;

import com.makingwheel.common.QueryParameters;
import com.makingwheel.dao.entity.SMClass;

public interface SMClassDao {

	public List<SMClass> list(QueryParameters queryParams);
	
	public int queryListCount(QueryParameters queryParams);
}
