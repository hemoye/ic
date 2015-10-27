package com.jsu.ic.dao.impl;

import org.springframework.stereotype.Repository;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.dao.PowerDAO;
import com.jsu.ic.po.Power;

@Repository("powerDAO")
public class PowerDAOImpl extends DaoSupportImpl<Power> implements PowerDAO {

}
