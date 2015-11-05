package com.jsu.ic.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.dao.KeyWordDAO;
import com.jsu.ic.po.Keyword;
import com.jsu.ic.service.KeyWordService;
import com.jsu.ic.vo.PageBean;

@Service("keyWordService")
public class KeyWordServiceImpl extends DaoSupportImpl<Keyword> implements KeyWordService {

	@Resource
	private KeyWordDAO dao;
	
	@Override
	public PageBean getPageBean(int pageNum, int pageSize, Date beginTime, Date endTime, String word) {
		return dao.getPageBean(pageNum, pageSize, beginTime, endTime, word);
	}

	@Override
	public void deleteByIds(Integer[] ids) {
		dao.deleteByIds(ids);
	}

}
