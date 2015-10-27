package com.jsu.ic.dao.impl;

import org.springframework.stereotype.Repository;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.dao.ProvinceDAO;
import com.jsu.ic.po.Province;

@Repository("provinceDAO")
public class ProvinceDAOImpl extends DaoSupportImpl<Province> implements ProvinceDAO {

}
