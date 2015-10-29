package com.jsu.ic.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.dao.SysLogDAO;
import com.jsu.ic.po.Syslog;

@SuppressWarnings("unchecked")
@Repository("sysLogDAO")
public class SysLogDAOImpl extends DaoSupportImpl<Syslog> implements SysLogDAO {

	@Override
	public List<Syslog> findByDate(Date beginTime, Date endTime) {
		log.debug("find Syslog by beginTime: " + beginTime + " and endTime: " + endTime);
		try {
			String queryString = "from Syslog as model where model.logTime >= ? and model.logTime <= ?";
			return getSession().createQuery(queryString).setDate(0, beginTime).setDate(1, endTime).list();
		} catch (RuntimeException re) {
			log.error("find failed", re);
			throw re;
		}
	}

}
