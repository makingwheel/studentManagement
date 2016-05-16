package com.makingwheel.model.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makingwheel.common.CollectionUtils;
import com.makingwheel.dao.entity.Manager;
import com.makingwheel.dao.impl.ManagerDaoImpl;
import com.makingwheel.model.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerDaoImpl ManagerDaoImpl;

	@Override
	public Manager save(Manager manager) {
		return ManagerDaoImpl.save(manager);
	}

	@Override
	public Optional<Manager> find(Long id) {
		return ManagerDaoImpl.find(id);
	}

	@Override
	public Optional<Manager> findByCount(String count) {
		List<Manager> managers = ManagerDaoImpl.findByCount(count);
		return CollectionUtils.validate(managers) ? Optional.ofNullable(managers.get(0)) : Optional.ofNullable(null);
	}

}
