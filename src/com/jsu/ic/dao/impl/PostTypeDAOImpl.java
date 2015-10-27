package com.jsu.ic.dao.impl;

import org.springframework.stereotype.Repository;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.dao.PostTypeDAO;
import com.jsu.ic.po.Posttype;

@Repository("postTypeDAO")
public class PostTypeDAOImpl extends DaoSupportImpl<Posttype> implements PostTypeDAO {

}
