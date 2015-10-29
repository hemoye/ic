package com.jsu.ic.action;

import org.apache.struts2.ServletActionContext;

import com.jsu.ic.annotation.Log;
import com.jsu.ic.base.MyActionSupport;
import com.jsu.ic.commons.Const;
import com.jsu.ic.po.User;

public class LogoutAction extends MyActionSupport<User> {

	private static final long serialVersionUID = -5641302429413153669L;

	@Log("退出登录")
	public String index() {
		model = getCurrentUser();
		if (model != null) {
			ServletActionContext.getContext().getSession().remove(Const.LOGIN_USER_SESSION_KEY);
			Const.loginUsers.remove(model);
		}
		return "index";
	}
}
