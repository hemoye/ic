package com.jsu.ic.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 可能抛出模块异常，需要配置在【错误代码消息装载器】后面
 * 访问控制，权限控制
 * @author hadoop
 *
 */
@SuppressWarnings("serial")
public class AccessControlInterceptor implements Interceptor {
	

	
	@Override
	public void destroy() {
	}

	@Override
	public void init() {
	}


	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		
		/**
		 * 登陆控制
		 */
//		if(arg0.getProxy().getNamespace().matches(Const.LOGIN_BASE_URI_REGX)){
//			SessionUserVO user = (SessionUserVO) ServletActionContext.getRequest()
//					.getSession().getAttribute(Const.LOGIN_USER_SESSION_KEY);
//			if(user==null){
//				throw new CodeException(1);
//			}
//		}
		/**
		 * 模块控制
		 */
		return arg0.invoke();
	
	}

	

}
