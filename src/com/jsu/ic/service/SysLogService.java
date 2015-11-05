package com.jsu.ic.service;

import java.util.Date;
import java.util.List;

import com.jsu.ic.base.DaoSupport;
import com.jsu.ic.po.Syslog;
import com.jsu.ic.vo.PageBean;

public interface SysLogService extends DaoSupport<Syslog> {

	/**
	 * 获取某一个时间段内的访问记录
	 * 
	 * @param beginTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @return 日志记录集合
	 */
	List<Syslog> findByDate(Date beginTime, Date endTime);

	/**
	 * 分页：获取第(pageNum - 1) * pageSize 至 pageNum * pageSize中间的记录
	 * 
	 * @param pageNum
	 *            当前页码
	 * @param pageSize
	 *            页面大小
	 * @param beginTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @param userName
	 *            用户名
	 * @param isSuccess
	 *            是否成功
	 * @return 分页对象
	 */
	PageBean getPageBean(int pageNum, int pageSize, Date beginTime, Date endTime, String userName, Integer isSuccess);

}
