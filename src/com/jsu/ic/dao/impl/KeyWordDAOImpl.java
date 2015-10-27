package com.jsu.ic.dao.impl;

import org.springframework.stereotype.Repository;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.dao.KeyWordDAO;
import com.jsu.ic.po.Keyword;

@Repository("keyWordDAO")
public class KeyWordDAOImpl extends DaoSupportImpl<Keyword> implements KeyWordDAO {

}
