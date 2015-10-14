package com.jsu.ic.interceptor;


import com.jsu.ic.exception.CodeException;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 错误代码消息装载器
 * 
 * @author hadoop
 *
 */
@SuppressWarnings("serial")
public class CodeExceptionInterceptor implements Interceptor {
//	该对象取不到国际化内容
//	private TextProvider textProvider;
//
//	@Inject
//	public void setTextProvider(TextProvider textProvider) {
//		this.textProvider = textProvider;
//	}

	@Override
	public void destroy() {
	}

	@Override
	public void init() {
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		try {
			return arg0.invoke();
		} catch (Exception ex) {
			if (ex instanceof CodeException && arg0.getAction() instanceof ActionSupport) {
				try {
					CodeException e = (CodeException) ex;
					ActionSupport action = (ActionSupport) arg0.getAction();
					String key = e.getKey();
					int code = e.getCode();
					if(code>0){
						String message = action.getText(key+"."+code);
						e.setMessage(message);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			throw ex;
		}
	}

}
