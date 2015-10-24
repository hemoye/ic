package com.jsu.ic.service.impl;

import org.springframework.stereotype.Service;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.po.Message;
import com.jsu.ic.service.MessageService;

@Service
public class MessageServiceImpl extends DaoSupportImpl<Message> implements MessageService {

}
