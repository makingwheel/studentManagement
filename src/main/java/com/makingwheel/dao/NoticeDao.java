package com.makingwheel.dao;

import java.util.List;

import com.makingwheel.dao.entity.Notice;

public interface NoticeDao {
	
	public List<Notice> queryByStatus(Integer status);
}
