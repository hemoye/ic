package com.jsu.ic.interceptor;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 字符编码拦截器
 * 
 * @author hadoop
 * 
 */

public class CharacterEncodingInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7951533924732170327L;
	private static final String n = Long.toString(serialVersionUID, 16);

	@Override
	public void destroy() {

	}

	@Override
	public void init() {
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {

		HttpServletRequest request = (HttpServletRequest) arg0.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);

		if (request.getAttribute(n) == null) {
			request.setAttribute(n, true);

			request.setCharacterEncoding("UTF-8");
			HttpServletResponse response = (HttpServletResponse) arg0.getInvocationContext().get(StrutsStatics.HTTP_RESPONSE);
			response.setCharacterEncoding("UTF-8");

			if ("GET".equals(request.getMethod().toUpperCase())) {
				Iterator<String[]> iter = request.getParameterMap().values().iterator();
				while (iter.hasNext()) {
					String[] parames = iter.next();
					for (int i = 0; i < parames.length; i++) {
						try {
							parames[i] = new String(parames[i].getBytes("ISO8859-1"), "UTF-8");
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return arg0.invoke();
	}

}
