package com.makingwheel.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makingwheel.common.PageResult;
import com.makingwheel.common.QueryParameters;
import com.makingwheel.dao.entity.Notice;
import com.makingwheel.dao.impl.NoticeDaoImpl;
import com.makingwheel.model.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDaoImpl noticeDaoImpl;
	
	@Override
	public PageResult queryByStatus(Integer status, QueryParameters queryParameters) {
		PageResult pageResult = new PageResult();
		List<Notice> notices = noticeDaoImpl.queryByStatus(status, queryParameters);
		Integer count = noticeDaoImpl.queryCountByStatus(status);
		pageResult.setRows(notices);
		pageResult.setTotal(count);
		return pageResult;
	}

}
