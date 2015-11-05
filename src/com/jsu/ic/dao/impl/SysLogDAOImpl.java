package com.jsu.ic.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.commons.BeanTools;
import com.jsu.ic.commons.QueryHelper;
import com.jsu.ic.dao.SysLogDAO;
import com.jsu.ic.po.Syslog;
import com.jsu.ic.vo.PageBean;
import com.jsu.ic.vo.SyslogVO;

@SuppressWarnings("unchecked")
@Repository("sysLogDAO")
public class SysLogDAOImpl extends DaoSupportImpl<Syslog> implements SysLogDAO {

	@Override
	public List<Syslog> findByDate(Date beginTime, Date endTime) {
		log.debug("find Syslog by beginTime: " + beginTime + " and endTime: " + endTime);
		try {
			String queryString = "from Syslog as model where model.logTime >= ? and model.logTime <= ?";
			return getSession().createQuery(queryString).setDate(0, beginTime).setDate(1, endTime).list();
		} catch (RuntimeException re) {
			log.error("find failed", re);
			throw re;
		}
	}

	@Override
	public PageBean getPageBean(int pageNum, int pageSize, Date beginTime, Date endTime, String userName, Integer isSuccess) {
		QueryHelper queryHelper = new QueryHelper(Syslog.class, "syslog");
		if (null != userName && !"".equals(userName)) {
			queryHelper.addCondition("userinfo.user.userName like '%" + userName + "%'");
		}
		if (null != beginTime) {
			queryHelper.addCondition("logTime >= ?", beginTime);
		}
		if (null != endTime) {
			queryHelper.addCondition("logTime <= ?", endTime);
		}
		if (isSuccess == 1 || isSuccess == 0) {
			queryHelper.addCondition("isSuccess = ?", isSuccess == 1 ? true : false);
		}
		queryHelper.addOrderProperty("logId", false);
		PageBean logBean = getPageBean(pageNum, pageSize, queryHelper);

		List<Syslog> list = logBean.getRecordList();
		List<SyslogVO> logVOs = new ArrayList<SyslogVO>();
		for (Syslog syslog : list) {
			SyslogVO vo = new SyslogVO();
			BeanTools.copyProperties(syslog, vo);
			vo.setUserName(syslog.getUserinfo().getUser().getUserName());
			logVOs.add(vo);
		}
		logBean.setRecordList(logVOs);
		return logBean;
	}

}
