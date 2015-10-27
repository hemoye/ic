package com.jsu.ic.dao.impl;

import org.springframework.stereotype.Repository;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.dao.ResourceTypeDAO;
import com.jsu.ic.po.Resourcetype;

@Repository("resourceTypeDAO")
public class ResourceTypeDAOImpl extends DaoSupportImpl<Resourcetype> implements ResourceTypeDAO {

}
