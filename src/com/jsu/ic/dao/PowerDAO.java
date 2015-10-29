package com.jsu.ic.dao;

import java.util.List;

import com.jsu.ic.base.DaoSupport;
import com.jsu.ic.po.Power;
import com.jsu.ic.po.Userrole;

public interface PowerDAO extends DaoSupport<Power> {

	/**
	 * 查询某一角色具有的权限
	 * 
	 * @param userrole
	 *            角色实体
	 * @return 权限列表
	 */
	List<Power> findByRole(Userrole userrole);

}
