package com.makingwheel.dao;

import java.util.List;

import com.makingwheel.common.QueryParameters;

public interface SMClassDao {

	public List<Object[]> list(QueryParameters queryParams);
}
