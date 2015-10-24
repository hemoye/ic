package com.jsu.ic.service.impl;

import org.springframework.stereotype.Service;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.po.Userinfo;
import com.jsu.ic.service.UserInfoService;

@Service(value = "userInfoService")
public class UserInfoServiceImpl extends DaoSupportImpl<Userinfo> implements UserInfoService {

}
