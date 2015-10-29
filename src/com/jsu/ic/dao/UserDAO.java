package com.jsu.ic.dao;

import java.util.Date;

import com.jsu.ic.base.DaoSupport;
import com.jsu.ic.po.User;
import com.jsu.ic.vo.PageBean;

public interface UserDAO extends DaoSupport<User> {

	/**
	 * 以用户名/邮箱/手机+密码的进行登录
	 * 
	 * @param userName
	 *            用户名/邮箱/手机
	 * @param userPwd
	 *            密码
	 * @return 用户实体的表现层对象
	 */
	User login(String userName, String userPwd);

	/**
	 * 分页: 获取第(pageNum - 1) * pageSize 至 pageNum * pageSize中间的记录
	 * 
	 * @param pageNum
	 *            当前页
	 * @param pageSize
	 *            页面大小
	 * @param beginTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @param userName
	 *            检索标识
	 * @param roleId
	 *            角色标识
	 * @return 用户集合
	 */
	PageBean getPageBean(int pageNum, int pageSize, Date beginTime, Date endTime, String userName, Integer roleId);

}
