package com.jsu.ic.dao.impl;

import org.springframework.stereotype.Repository;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.dao.ApproveDAO;
import com.jsu.ic.po.Approve;

@Repository("approveDAO")
public class ApproveDAOImpl extends DaoSupportImpl<Approve> implements ApproveDAO {

}
