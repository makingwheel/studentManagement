package com.makingwheel.dao;

import java.util.List;

import com.makingwheel.dao.entity.User;

public interface UserDao {

	public List<User> queryByCountAndType(String count, Integer type);
}
