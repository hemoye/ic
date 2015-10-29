package com.jsu.ic.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.dao.PowerDAO;
import com.jsu.ic.po.Power;
import com.jsu.ic.po.Userrole;

@SuppressWarnings("unchecked")
@Repository("powerDAO")
public class PowerDAOImpl extends DaoSupportImpl<Power> implements PowerDAO {

	@Override
	public List<Power> findByRole(Userrole userrole) {
		log.debug("find Power by userrole: " + userrole.getRoleId());
		try {
			String queryString = "from Power as model where model.userrole.roleId = ? and model.power is null";
			return getSession().createQuery(queryString).setParameter(0, userrole.getRoleId()).list();
		} catch (RuntimeException re) {
			log.error("find failed", re);
			throw re;
		}
	}

	
}
