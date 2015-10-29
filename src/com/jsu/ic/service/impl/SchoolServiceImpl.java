package com.jsu.ic.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.dao.SchoolDAO;
import com.jsu.ic.po.School;
import com.jsu.ic.service.SchoolService;

@Service("schoolService")
public class SchoolServiceImpl extends DaoSupportImpl<School> implements SchoolService {

	@Resource
	private SchoolDAO dao;
	
	@Override
	public List<School> findByDate(Date beginTime, Date endTime) {
		return dao.findByDate(beginTime, endTime);
	}

}
