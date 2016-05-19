package com.makingwheel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.makingwheel.common.QueryParameters;
import com.makingwheel.dao.BasicDao;
import com.makingwheel.dao.SMClassDao;
import com.makingwheel.dao.entity.SMClass;

@Repository
public class SMClassDaoImpl extends BasicDao<SMClass>implements SMClassDao {

	@Override
	public List<Object[]> list(QueryParameters queryParams) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
