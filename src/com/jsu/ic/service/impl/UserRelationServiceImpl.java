package com.jsu.ic.service.impl;

import org.springframework.stereotype.Service;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.po.Userrelation;
import com.jsu.ic.service.UserRelationService;

@Service("userRelationService")
public class UserRelationServiceImpl extends DaoSupportImpl<Userrelation> implements UserRelationService {

}
