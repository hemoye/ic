package com.jsu.ic.action.back;

import org.springframework.stereotype.Controller;

import com.jsu.ic.annotation.Log;
import com.jsu.ic.base.MyActionSupport;
import com.jsu.ic.commons.Const;
import com.jsu.ic.exception.CodeException;
import com.jsu.ic.po.User;
import com.opensymphony.xwork2.ActionContext;

@Controller
public class LoginAction extends MyActionSupport<User> {

	private static final long serialVersionUID = 1138358773335213784L;

	@Log("后台登录界面")
	public String index() {
		return "loginUI";
	}

	@Log("后台登录")
	public String login() {
		if (null == model.getUserName() || null == model.getUserPwd() || "".equals(model.getUserName())
				|| "".equals(model.getUserPwd())) {
			print(Const.MESSAGE_KEY, Const.getMessage("code.14"));
			throw new CodeException(14);
		}
		model = userService.login(model.getUserName(), model.getUserPwd());
		if (null == model) {
			print(Const.MESSAGE_KEY, Const.getMessage("code.10"));
			throw new CodeException(10);
		} else if (null != model.getFrostLength() && model.getFrostLength() > 0) {
			print(Const.MESSAGE_KEY, Const.getMessage("code.11"));
			throw new CodeException(11);
		} else if (model.getIsDelete()) {
			print(Const.MESSAGE_KEY, Const.getMessage("code.12"));
			throw new CodeException(12);
		} else if (null == model.getUserrole() || model.getUserrole().getRoleName().equals("普通用户")) {
			print(Const.MESSAGE_KEY, Const.getMessage("code.13"));
			throw new CodeException(13);
		}
		ActionContext.getContext().getSession().put(Const.LOGIN_USER_SESSION_KEY, model);
		if (!Const.loginUsers.contains(model)) {
			Const.loginUsers.add(model);
		}
		return "login";
	}
}
