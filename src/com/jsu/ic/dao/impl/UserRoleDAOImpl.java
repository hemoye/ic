package com.jsu.ic.dao.impl;

import org.springframework.stereotype.Repository;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.dao.UserRoleDAO;
import com.jsu.ic.po.Userrole;

@Repository("userRoleDAO")
public class UserRoleDAOImpl extends DaoSupportImpl<Userrole> implements UserRoleDAO {

}
