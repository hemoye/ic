package com.jsu.ic.dao.impl;

import org.springframework.stereotype.Repository;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.dao.SchoolDAO;
import com.jsu.ic.po.School;

@Repository("schoolDAO")
public class SchoolDAOImpl extends DaoSupportImpl<School> implements SchoolDAO {

}
