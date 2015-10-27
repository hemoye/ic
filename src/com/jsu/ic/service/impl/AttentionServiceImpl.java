package com.jsu.ic.service.impl;

import org.springframework.stereotype.Service;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.po.Attention;
import com.jsu.ic.service.AttentionService;

@Service("attentionService")
public class AttentionServiceImpl extends DaoSupportImpl<Attention> implements AttentionService {

}
