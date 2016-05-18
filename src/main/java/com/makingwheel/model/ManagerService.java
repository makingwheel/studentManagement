package com.makingwheel.model;

import java.util.Optional;

import com.makingwheel.dao.entity.Manager;

public interface ManagerService {
	
	public Manager save(Manager manager);
	
	public Optional<Manager> find(Long id);
	
	public Optional<Manager> findByCount(String count);
}
