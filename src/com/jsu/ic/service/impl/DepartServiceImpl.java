package com.jsu.ic.service.impl;

import org.springframework.stereotype.Service;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.po.Depart;
import com.jsu.ic.service.DepartService;

@Service("departService")
public class DepartServiceImpl extends DaoSupportImpl<Depart> implements DepartService {

}
