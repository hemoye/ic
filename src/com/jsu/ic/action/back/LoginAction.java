package com.jsu.ic.action.back;

import org.springframework.stereotype.Controller;

import com.jsu.ic.annotation.Log;
import com.jsu.ic.base.MyActionSupport;
import com.jsu.ic.po.User;

@Controller
public class LoginAction extends MyActionSupport<User> {

	private static final long serialVersionUID = 1138358773335213784L;

	@Log("进入登录界面")
	public String index() {
		return "loginUI";
	}

	@Log("登录")
	public String login() {
		return "login";
	}
}
