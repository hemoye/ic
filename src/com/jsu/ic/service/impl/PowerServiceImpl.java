package com.jsu.ic.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.dao.PowerDAO;
import com.jsu.ic.po.Power;
import com.jsu.ic.po.Userrole;
import com.jsu.ic.service.PowerService;

@Service("powerService")
public class PowerServiceImpl extends DaoSupportImpl<Power> implements PowerService {

	@Resource
	private PowerDAO dao;
	
	@Override
	public List<Power> findByRole(Userrole userrole) {
		return dao.findByRole(userrole);
	}

}
