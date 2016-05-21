package com.makingwheel.model.impl;

import java.util.List;
import java.util.Optional;

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

	@Override
	public PageResult list(QueryParameters queryParameters) {
		PageResult pageResult = new PageResult();
		List<Notice> notices = noticeDaoImpl.query(queryParameters);
		Integer count = noticeDaoImpl.queryCount();
		pageResult.setRows(notices);
		pageResult.setTotal(count);
		return pageResult;
	}

	
	@Override
	public Optional<Notice> find(Long noticeId) {
		return noticeDaoImpl.find(noticeId);
	}

	@Override
	public void saveOrUpdate(Notice notice) {
		noticeDaoImpl.saveOrUpdate(notice);
	}

	@Override
	public void updateStatus(Long noticeId, int status) {
		noticeDaoImpl.find(noticeId).ifPresent(x -> {
			x.setStatus(status);
			noticeDaoImpl.saveOrUpdate(x);
		});
	}


}
