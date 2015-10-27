package com.jsu.ic.dao.impl;

import org.springframework.stereotype.Repository;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.dao.SysLogDAO;
import com.jsu.ic.po.Syslog;

@Repository("sysLogDAO")
public class SysLogDAOImpl extends DaoSupportImpl<Syslog> implements SysLogDAO {

}
