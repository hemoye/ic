package com.jsu.ic.service.impl;

import org.springframework.stereotype.Service;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.po.Userpost;
import com.jsu.ic.service.UserPostService;

@Service("userPostService")
public class UserPostServiceImpl extends DaoSupportImpl<Userpost> implements UserPostService {

}
