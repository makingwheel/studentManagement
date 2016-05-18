package com.makingwheel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.makingwheel.dao.BasicDao;
import com.makingwheel.dao.ManagerDao;
import com.makingwheel.dao.entity.Manager;

@Repository
public class ManagerDaoImpl extends BasicDao<Manager>implements ManagerDao {

	@Override
	public List<Manager> findByCount(String count) {
		StringBuffer hql = new StringBuffer("from Manager m ");
		hql.append("where m.count = ? ");
		@SuppressWarnings("unchecked")
		List<Manager> managers = (List<Manager>) hibernateTemplate.find(hql.toString(), count);
		return managers;
	}

}
