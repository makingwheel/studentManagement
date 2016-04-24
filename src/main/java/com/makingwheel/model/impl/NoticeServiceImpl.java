package com.makingwheel.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.makingwheel.dao.NoticeDao;
import com.makingwheel.dao.entity.Notice;
import com.makingwheel.model.NoticeService;

public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public List<Notice> queryByStatus(Integer status) {
		hibernateTemplate.get(Notice.class, 1);
		return null;
	}

}
