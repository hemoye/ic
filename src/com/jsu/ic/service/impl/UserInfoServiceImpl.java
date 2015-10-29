package com.jsu.ic.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.dao.UserInfoDAO;
import com.jsu.ic.po.Userinfo;
import com.jsu.ic.service.UserInfoService;

@Service(value = "userInfoService")
public class UserInfoServiceImpl extends DaoSupportImpl<Userinfo> implements UserInfoService {

	@Resource
	private UserInfoDAO dao;

	public List<Userinfo> findByDate(Date beginTime, Date endTime) {
		return dao.findByDate(beginTime, endTime);
	}

}
