package com.jsu.ic.service.impl;

import org.springframework.stereotype.Service;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.po.Keyword;
import com.jsu.ic.service.KeyWordService;

@Service("keyWordService")
public class KeyWordServiceImpl extends DaoSupportImpl<Keyword> implements KeyWordService {

}
