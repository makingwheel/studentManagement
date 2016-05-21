package com.makingwheel.model;

import java.util.Optional;

import com.makingwheel.common.PageResult;
import com.makingwheel.common.QueryParameters;
import com.makingwheel.dao.entity.Notice;

public interface NoticeService {

	public PageResult queryByStatus(Integer status, QueryParameters queryParameters);
	
	public PageResult list(QueryParameters queryParameters);
	
	public Optional<Notice> find(Long noticeId);
	
	public void saveOrUpdate(Notice notice);
	
	public void updateStatus(Long notice, int status);
}
