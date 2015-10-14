package com.jsu.ic.interceptor;

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

//	@Autowired
//	public UserInfoService service;

	@Override
	public void destroy() {
	}

	@Override
	public void init() {
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {

		// SessionUserVO user = (SessionUserVO)
		// ServletActionContext.getRequest().getSession()
		// .getAttribute(Const.LOGIN_USER_SESSION_KEY);
		// if (user == null && Const.TEST_USER_ID > 0L) {
		//
		// ServletActionContext.getRequest().getSession()
		// .setAttribute(Const.LOGIN_USER_SESSION_KEY,
		// service.login(Const.TEST_USER_ID));
		// }

		return arg0.invoke();
	}

}
