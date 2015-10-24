package com.jsu.ic.dao;

import com.jsu.ic.base.DaoSupport;
import com.jsu.ic.po.User;
import com.jsu.ic.vo.UserVO;

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
	UserVO login(String userName, String userPwd);

}
