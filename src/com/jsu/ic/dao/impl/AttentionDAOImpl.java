package com.jsu.ic.dao.impl;

import org.springframework.stereotype.Repository;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.dao.AttentionDAO;
import com.jsu.ic.po.Attention;

@Repository("attentionDAO")
public class AttentionDAOImpl extends DaoSupportImpl<Attention> implements AttentionDAO {

}
