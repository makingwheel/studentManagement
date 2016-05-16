package com.makingwheel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.makingwheel.dao.BasicDao;
import com.makingwheel.dao.UserDao;
import com.makingwheel.dao.entity.User;

@Repository
public class UserDaoImpl extends BasicDao<User>implements UserDao {

	@Override
	public List<User> queryByCountAndType(String count, Integer type) {
		StringBuffer hql = new StringBuffer("from User u ");
		hql.append("where u.count = ? ");
		hql.append("and u.type = ? ");
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) hibernateTemplate.find(hql.toString(), count, type);
		return users;
	}

}
