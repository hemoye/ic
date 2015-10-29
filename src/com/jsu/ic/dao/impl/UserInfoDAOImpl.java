package com.jsu.ic.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.dao.UserInfoDAO;
import com.jsu.ic.po.Userinfo;

@SuppressWarnings("unchecked")
@Repository(value = "userInfoDAO")
public class UserInfoDAOImpl extends DaoSupportImpl<Userinfo> implements UserInfoDAO {

	@Override
	public List<Userinfo> findByDate(Date beginTime, Date endTime) {
		log.debug("find User by beginTime: " + beginTime + " and endTime: " + endTime);
		try {
			String queryString = "from Userinfo as model where model.registTime >= ? and model.registTime <= ?";
			return getSession().createQuery(queryString).setDate(0, beginTime).setDate(1, endTime).list();
		} catch (RuntimeException re) {
			log.error("find failed", re);
			throw re;
		}
	}

}
