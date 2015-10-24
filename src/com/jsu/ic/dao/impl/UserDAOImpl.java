package com.jsu.ic.dao.impl;

import org.springframework.stereotype.Repository;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.commons.BeanTools;
import com.jsu.ic.commons.MD5;
import com.jsu.ic.dao.UserDAO;
import com.jsu.ic.po.User;
import com.jsu.ic.vo.UserVO;

@Repository(value = "userDAO")
public class UserDAOImpl extends DaoSupportImpl<User> implements UserDAO {

	@Override
	public UserVO login(String userName, String userPwd) {
		UserVO vo = new UserVO();
		log.debug("find User by userName/userEmail/UserTel: " + userName + " and userPwd: " + userPwd);
		try {
			String queryString = "from User as model where (userName = ? or userEmail = ? or userTel = ?) and userPwd = ?";
			User user = (User) getSession().createQuery(queryString).setParameter(0, userName).setParameter(1, userName).setParameter(2, userName)
					.setParameter(3, MD5.MD5Encode(userPwd)).uniqueResult();
			BeanTools.copyProperties(user, vo);
			return vo;
		} catch (RuntimeException re) {
			log.error("find failed", re);
			throw re;
		}
	}

}
