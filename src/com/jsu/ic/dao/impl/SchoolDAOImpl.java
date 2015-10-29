package com.jsu.ic.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.dao.SchoolDAO;
import com.jsu.ic.po.School;

@SuppressWarnings("unchecked")
@Repository("schoolDAO")
public class SchoolDAOImpl extends DaoSupportImpl<School> implements SchoolDAO {

	@Override
	public List<School> findByDate(Date beginTime, Date endTime) {
		log.debug("find School by beginTime: " + beginTime + " and endTime: " + endTime);
		try {
			String queryString = "from School as model where (model.addTime >= ? and model.addTime <= ?) and model.school is null";
			return getSession().createQuery(queryString).setDate(0, beginTime).setDate(1, endTime).list();
		} catch (RuntimeException re) {
			log.error("find failed", re);
			throw re;
		}
	}
}
