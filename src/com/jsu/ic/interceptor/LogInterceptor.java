package com.jsu.ic.interceptor;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.jsu.ic.annotation.Log;
import com.jsu.ic.commons.Const;
import com.jsu.ic.po.Syslog;
import com.jsu.ic.po.User;
import com.jsu.ic.service.SysLogService;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 日志记录拦截器
 * 
 * @author hadoop
 * 
 */
public class LogInterceptor implements Interceptor {

	private static final long serialVersionUID = -4109623042388223280L;
	
	@Resource
	private SysLogService service;

	@Override
	public void destroy() {

	}

	@Override
	public void init() {
	}

	@Override
	public String intercept(ActionInvocation invok) throws Exception {
		String method = invok.getProxy().getMethod();
		if (invok.getAction().getClass().getMethod(method).isAnnotationPresent(Log.class)) {
			String ret = null;
			Exception ex = null;
			HttpServletRequest request = ServletActionContext.getRequest();
			Log log = invok.getAction().getClass().getMethod(method).getAnnotation(Log.class);
			Syslog syslog = new Syslog();
			syslog.setLogIp(request.getRemoteAddr());
			syslog.setIsSuccess(true);
			syslog.setLogName(log.value());
			syslog.setLogTxt("");
			syslog.setLogTime(new Timestamp(new Date().getTime()));
			if (request.getSession().getAttribute(Const.LOGIN_USER_SESSION_KEY) == null) {
				syslog.setUserinfo(null);
			} else {
				User user = (User) request.getSession().getAttribute(Const.LOGIN_USER_SESSION_KEY);
				syslog.setUserinfo(user.getUserinfo());
			}
			try {
				ret = invok.invoke();
			} catch (Exception e) {
				ex = e;
				StringWriter out = new StringWriter();
				PrintWriter pw = new PrintWriter(out);
				e.printStackTrace(pw);
				syslog.setIsSuccess(false);
				syslog.setLogTxt(out.toString());
			}

			if (syslog.getUserinfo() == null && request.getSession().getAttribute(Const.LOGIN_USER_SESSION_KEY) != null) {
				User user = (User) request.getSession().getAttribute(Const.LOGIN_USER_SESSION_KEY);
				syslog.setUserinfo(user.getUserinfo());
			}
			System.out.println(syslog.getLogTxt());
			service.save(syslog);

			if (ex == null) {
				return ret;
			} else {
				throw ex;
			}
		} else {
			return invok.invoke();
		}

	}

}
