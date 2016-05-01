package com.makingwheel.model.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makingwheel.common.CollectionUtils;
import com.makingwheel.controller.sign.UserVo;
import com.makingwheel.dao.entity.User;
import com.makingwheel.dao.impl.UserDaoImpl;
import com.makingwheel.model.SignService;

@Service
public class SignServiceImpl implements SignService {

	@Autowired
	private UserDaoImpl userDaoImpl;

	@Override
	public boolean checkUser(UserVo userVo) {
		Boolean result = false;
		Optional<User> user = queryByUserVo(userVo);
		if (user.isPresent()) {
			result = checkPassword(user.get().getPassword(), userVo.getPassword());
		}
		return result;
	}

	@Override
	public Optional<User> queryByUserVo(UserVo userVo) {
		List<User> users = userDaoImpl.queryByCountAndType(userVo.getCount(), userVo.getType());
		return CollectionUtils.validate(users) ? Optional.ofNullable(users.get(0)) : Optional.ofNullable(null);
	}

	private boolean checkPassword(String target, String value) {
		return value.equals(value);
	}
}
