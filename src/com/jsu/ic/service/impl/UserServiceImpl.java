package com.jsu.ic.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.dao.UserDAO;
import com.jsu.ic.po.User;
import com.jsu.ic.service.UserService;
import com.jsu.ic.vo.UserVO;

@Service(value = "userService")
public class UserServiceImpl extends DaoSupportImpl<User> implements UserService {

	@Resource
	private UserDAO dao;

	@Override
	public UserVO login(String userName, String userPwd) {
		return dao.login(userName, userPwd);
	}

}
