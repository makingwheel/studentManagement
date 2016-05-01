package com.makingwheel.model;

import java.util.Optional;

import com.makingwheel.controller.sign.UserVo;
import com.makingwheel.dao.entity.User;

public interface SignService {

	public boolean checkUser(UserVo userVo);
	
	public Optional<User> queryByUserVo(UserVo userVo);
}
