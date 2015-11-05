package com.jsu.ic.dao;

import java.util.Date;

import com.jsu.ic.base.DaoSupport;
import com.jsu.ic.po.Keyword;
import com.jsu.ic.vo.PageBean;

public interface KeyWordDAO extends DaoSupport<Keyword> {

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
	 * @param word
	 *            敏感词
	 * @return 分页对象
	 */
	PageBean getPageBean(int pageNum, int pageSize, Date beginTime, Date endTime, String word);

	/**
	 * 根据一组标识删除一组敏感词
	 * 
	 * @param ids
	 *            标识数组
	 */
	void deleteByIds(Integer[] ids);

}
