package com.jsu.ic.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.dao.SysLogDAO;
import com.jsu.ic.po.Syslog;
import com.jsu.ic.service.SysLogService;

@Service("sysLogService")
public class SysLogServiceImpl extends DaoSupportImpl<Syslog> implements SysLogService {

	@Resource
	private SysLogDAO dao;

	@Override
	public List<Syslog> findByDate(Date beginTime, Date endTime) {
		return dao.findByDate(beginTime, endTime);
	}

}
