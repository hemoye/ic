package com.jsu.ic.dao.impl;

import org.springframework.stereotype.Repository;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.dao.HeadDAO;
import com.jsu.ic.po.Head;

@Repository("headDAO")
public class HeadDAOImpl extends DaoSupportImpl<Head> implements HeadDAO {

}
