package com.makingwheel.model;

import java.util.List;

import com.makingwheel.dao.entity.Notice;

public interface NoticeService {

	public List<Notice> queryByStatus(Integer status);
}
