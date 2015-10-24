package com.jsu.ic.dao.impl;

import org.springframework.stereotype.Repository;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.dao.UserInfoDAO;
import com.jsu.ic.po.Userinfo;

@Repository(value = "userInfoDAO")
public class UserInfoDAOImpl extends DaoSupportImpl<Userinfo> implements UserInfoDAO {

}
