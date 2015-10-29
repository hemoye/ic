package com.jsu.ic.dao;

import java.util.Date;
import java.util.List;

import com.jsu.ic.base.DaoSupport;
import com.jsu.ic.po.School;

public interface SchoolDAO extends DaoSupport<School> {

	/**
	 * 查询某一时间段内注册的学校
	 * 
	 * @param beginTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @return 学校集合
	 */
	List<School> findByDate(Date beginTime, Date endTime);

}
