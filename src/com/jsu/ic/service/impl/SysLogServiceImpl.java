package com.jsu.ic.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.dao.SysLogDAO;
import com.jsu.ic.po.Syslog;
import com.jsu.ic.service.SysLogService;
import com.jsu.ic.vo.PageBean;

@Service("sysLogService")
public class SysLogServiceImpl extends DaoSupportImpl<Syslog> implements SysLogService {

	@Resource
	private SysLogDAO dao;

	@Override
	public List<Syslog> findByDate(Date beginTime, Date endTime) {
		return dao.findByDate(beginTime, endTime);
	}

	@Override
	public PageBean getPageBean(int pageNum, int pageSize, Date beginTime, Date endTime, String userName, Integer isSuccess) {
		return dao.getPageBean(pageNum, pageSize, beginTime, endTime, userName, isSuccess);
	}

}
