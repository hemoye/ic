package com.jsu.ic.interceptor;

import com.jsu.ic.exception.CodeException;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 错误视图拦截器
 * 
 * @author hadoop
 */
@SuppressWarnings("serial")
public class ErrorPageInterceptor implements Interceptor {

	@Override
	public void destroy() {

	}

	@Override
	public void init() {
	}

	@Override
	public String intercept(ActionInvocation invoke) throws Exception {
		String ret = null;
		try {
			ret = invoke.invoke();
		} catch (Throwable ex) {
//			MyActionSupport action = (MyActionSupport) invoke.getAction();
			CodeException e = null;
			if (ex instanceof CodeException) {
				e = (CodeException) ex;
			} else {
				e = new CodeException(-1, ex);
				e.setMessage(ex.getMessage() == null ? ex.toString() : ex.getMessage());
			}
//			String method = invoke.getProxy().getMethod();
			return "loginUI";
		}
		return ret;
	}

}
