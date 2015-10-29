package com.jsu.ic.commons;

import org.apache.struts2.ServletActionContext;

import com.jsu.ic.po.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 自定义拦截器
 * 
 * @author hadoop
 * 
 */
public class MyInterceptor implements Interceptor {

	private static final long serialVersionUID = 5596193685303607889L;

	@Override
	public void destroy() {
	}

	@Override
	public void init() {
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		User user = (User) invocation.getInvocationContext().getSession().get(Const.LOGIN_USER_SESSION_KEY);

		// 获取浏览器访问URL
		String URL = ServletActionContext.getRequest().getHeader("Referer");
		String method = invocation.getProxy().getMethod();
		// 如果访问的是后台管理页面(manage命名空间下的)
		if (URL == null || URL.contains("manage")) {
			if (!method.contains("login") && null == user) { // 如果没有登录
				return "notLogin";
			}
		}
		return invocation.invoke();
	}

}
