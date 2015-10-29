package com.jsu.ic.action.back;

import org.springframework.stereotype.Controller;

import com.jsu.ic.annotation.Log;
import com.jsu.ic.base.MyActionSupport;
import com.jsu.ic.po.User;
import com.jsu.ic.vo.PageBean;

@Controller
public class UserManageAction extends MyActionSupport<User> {

	private static final long serialVersionUID = 1L;
	private Integer roleId; // 用户角色
	private PageBean userBean;

	@Log("用户管理")
	public String index() {
		model = getCurrentUser();
		msg.put("powers", powerService.findByRole(model.getUserrole()));

		return "index";
	}

	@Log("加载用户列表")
	public void loadData() {
		model = getCurrentUser();
		userBean = userService.getPageBean(pageNum, pageSize, beginTime, endTime, model.getUserName(), roleId);
		json(userBean);
	}

	public PageBean getUserBean() {
		return userBean;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}
