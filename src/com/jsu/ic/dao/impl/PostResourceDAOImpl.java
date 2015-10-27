package com.jsu.ic.dao.impl;

import org.springframework.stereotype.Repository;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.dao.PostResourceDAO;
import com.jsu.ic.po.Postresource;

@Repository("postResourceDAO")
public class PostResourceDAOImpl extends DaoSupportImpl<Postresource> implements PostResourceDAO {

}
