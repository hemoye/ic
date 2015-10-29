package com.jsu.ic.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.dao.UserDAO;
import com.jsu.ic.po.User;
import com.jsu.ic.service.UserService;
import com.jsu.ic.vo.PageBean;

@Service(value = "userService")
public class UserServiceImpl extends DaoSupportImpl<User> implements UserService {

	@Resource
	private UserDAO dao;

	@Override
	public User login(String userName, String userPwd) {
		return dao.login(userName, userPwd);
	}

	@Override
	public PageBean getPageBean(int pageNum, int pageSize, Date beginTime, Date endTime, String userName, Integer roleId) {
		return dao.getPageBean(pageNum, pageSize, beginTime, endTime, userName, roleId);
	}


}
