package com.jsu.ic.dao;

import java.util.Date;
import java.util.List;

import com.jsu.ic.base.DaoSupport;
import com.jsu.ic.po.Syslog;

public interface SysLogDAO extends DaoSupport<Syslog> {

	/**
	 * 查询某一个时间段内的访问记录
	 * 
	 * @param beginTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @return 日志记录集合
	 */
	List<Syslog> findByDate(Date beginTime, Date endTime);

}
