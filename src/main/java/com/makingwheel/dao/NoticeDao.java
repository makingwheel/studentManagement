package com.makingwheel.dao;

import java.util.List;

import com.makingwheel.common.QueryParameters;
import com.makingwheel.dao.entity.Notice;

public interface NoticeDao {
	
	public List<Notice> queryByStatus(Integer status, QueryParameters queryParameters);
	
	public Integer queryCountByStatus(Integer status);
	
	public List<Notice> query(QueryParameters queryParameters);
	
	public Integer queryCount();
}
