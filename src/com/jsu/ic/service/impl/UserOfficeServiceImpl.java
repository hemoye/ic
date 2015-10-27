package com.jsu.ic.service.impl;

import org.springframework.stereotype.Service;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.po.Useroffice;
import com.jsu.ic.service.UserOfficeService;

@Service("userOfficeService")
public class UserOfficeServiceImpl extends DaoSupportImpl<Useroffice> implements UserOfficeService {

}
