package com.jsu.ic.dao;

import java.util.Date;
import java.util.List;

import com.jsu.ic.base.DaoSupport;
import com.jsu.ic.po.Userinfo;

public interface UserInfoDAO extends DaoSupport<Userinfo> {

	/**
	 * 查询某时间段内的注册用户
	 * 
	 * @param beginTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @return 用户详细信息集合
	 */
	List<Userinfo> findByDate(Date beginTime, Date endTime);

}
