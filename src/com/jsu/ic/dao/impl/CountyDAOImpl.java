package com.jsu.ic.dao.impl;

import org.springframework.stereotype.Repository;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.dao.CountyDAO;
import com.jsu.ic.po.County;

@Repository("countyDAO")
public class CountyDAOImpl extends DaoSupportImpl<County> implements CountyDAO {

}
