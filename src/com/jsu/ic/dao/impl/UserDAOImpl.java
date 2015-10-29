package com.jsu.ic.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jsu.ic.base.DaoSupportImpl;
import com.jsu.ic.commons.BeanTools;
import com.jsu.ic.commons.MD5;
import com.jsu.ic.commons.QueryHelper;
import com.jsu.ic.dao.UserDAO;
import com.jsu.ic.po.User;
import com.jsu.ic.vo.PageBean;
import com.jsu.ic.vo.UserVO;

@SuppressWarnings("unchecked")
@Repository(value = "userDAO")
public class UserDAOImpl extends DaoSupportImpl<User> implements UserDAO {

	@Override
	public User login(String userName, String userPwd) {
		log.debug("find User by userName/userEmail/UserTel: " + userName + " and userPwd: " + userPwd);
		try {
			String queryString = "from User as model where (userName = ? or userEmail = ? or userTel = ?) and userPwd = ?";
			return (User) getSession().createQuery(queryString).setParameter(0, userName).setParameter(1, userName)
					.setParameter(2, userName).setParameter(3, MD5.MD5Encode(userPwd)).uniqueResult();
		} catch (RuntimeException re) {
			log.error("find failed", re);
			throw re;
		}
	}

	@Override
	public PageBean getPageBean(int pageNum, int pageSize, Date beginTime, Date endTime, String userName, Integer roleId) {
		QueryHelper queryHelper = new QueryHelper(User.class, "user");
		if (null != userName && !"".equals(userName)) {
			queryHelper.addCondition("userName like '%" + userName + "%'");
		}
		if (roleId > 0) {
			queryHelper.addCondition("userrole.roleId = ?", roleId);
		}
		if (null != beginTime) {
			queryHelper.addCondition("userinfo.registTime >= ?", beginTime);
		}
		if (null != endTime) {
			queryHelper.addCondition("userinfo.registTime <= ?", endTime);
		}
		queryHelper.addOrderProperty("userId", true);
		PageBean userBean = getPageBean(pageNum, pageSize, queryHelper);

		List<UserVO> userVOs = BeanTools.copyProperties(userBean.getRecordList(), new UserVO());
		userBean.setRecordList(userVOs);

		return userBean;
	}

}
