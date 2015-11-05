package com.jsu.ic.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.dao.HeadDAO;
import com.jsu.ic.po.Head;
import com.jsu.ic.service.HeadService;
import com.jsu.ic.vo.PageBean;

@Service("headService")
public class HeadServiceImpl extends DaoSupportImpl<Head> implements HeadService {

	@Resource
	private HeadDAO dao;

	@Override
	public PageBean getPageBean(int pageNum, int pageSize, Date beginTime, Date endTime) {
		return dao.getPageBean(pageNum, pageSize, beginTime, endTime);
	}

	@Override
	public void deleteByIds(Integer[] ids) {
		dao.deleteByIds(ids);
	}

}
