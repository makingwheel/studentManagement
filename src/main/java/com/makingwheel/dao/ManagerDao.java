package com.makingwheel.dao;

import java.util.List;

import com.makingwheel.dao.entity.Manager;

public interface ManagerDao {

	public List<Manager> findByCount(String count);
}
