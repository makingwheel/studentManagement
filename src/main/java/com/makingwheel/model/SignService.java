package com.makingwheel.model;

import java.util.Optional;

import com.makingwheel.dao.entity.User;
import com.makingwheel.model.vo.UserVo;

public interface SignService {

	public boolean checkUser(UserVo userVo);
	
	public Optional<User> queryByUserVo(UserVo userVo);
}
