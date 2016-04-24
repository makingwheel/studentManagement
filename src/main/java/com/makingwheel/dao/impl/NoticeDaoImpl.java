package com.makingwheel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.makingwheel.dao.BasicDao;
import com.makingwheel.dao.NoticeDao;
import com.makingwheel.dao.entity.Notice;

@Repository
public class NoticeDaoImpl extends BasicDao<Notice>implements NoticeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Notice> queryByStatus(Integer status) {
		StringBuffer hql = new StringBuffer("from Notice n ");
		hql.append("where n.status = ? ");
		return (List<Notice>) hibernateTemplate.find(hql.toString(), status);
	}

	
	
}
