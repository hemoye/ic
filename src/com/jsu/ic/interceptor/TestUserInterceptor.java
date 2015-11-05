package com.jsu.ic.interceptor;

import javax.annotation.Resource;

import com.jsu.ic.commons.Const;
import com.jsu.ic.po.User;
import com.jsu.ic.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 开发时，根据自己的需求自动添加登陆用户
 * 
 * @author hadoop
 * 
 */
@SuppressWarnings("serial")
public class TestUserInterceptor implements Interceptor {

	@Resource
	public UserService service;

	@Override
	public void destroy() {
	}

	@Override
	public void init() {
	}

	@Override
	public String intercept(ActionInvocation invoke) throws Exception {
		User user = (User) ActionContext.getContext().getSession().get(Const.LOGIN_USER_SESSION_KEY);
		if (user == null && Const.TEST_USER_ID > 0L) {
			ActionContext.getContext().getSession().put(Const.LOGIN_USER_SESSION_KEY, service.findById(Const.TEST_USER_ID));
		}
		return invoke.invoke();
	}

}
