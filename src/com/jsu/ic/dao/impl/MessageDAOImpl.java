package com.jsu.ic.dao.impl;

import org.springframework.stereotype.Repository;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.dao.MessageDAO;
import com.jsu.ic.po.Message;

@Repository("messageDAO")
public class MessageDAOImpl extends DaoSupportImpl<Message> implements MessageDAO {

}
