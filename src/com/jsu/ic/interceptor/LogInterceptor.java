package com.jsu.ic.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 日志记录拦截器
 * 
 * @author hadoop
 * 
 */
@SuppressWarnings("serial")
public class LogInterceptor implements Interceptor {

	// @Autowired
	// private LogService service;

	@Override
	public void destroy() {

	}

	@Override
	public void init() {
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {

		return null;
		// String method = arg0.getProxy().getMethod();
		// if (!"execute".equals(method)) {
		// method = "do" + method.substring(0, 1).toUpperCase() +
		// method.substring(1);
		// }
		//
		// if
		// (arg0.getAction().getClass().getMethod(method).isAnnotationPresent(Log.class))
		// {
		// String ret = null;
		// Exception ex = null;
		// HttpServletRequest request = ServletActionContext.getRequest();
		// Log log =
		// arg0.getAction().getClass().getMethod(method).getAnnotation(Log.class);
		// Logs logs = new Logs();
		// logs.setD(Const.getDate());
		// logs.setDoing(log.value());
		// logs.setIp(request.getRemoteAddr());
		// logs.setSuccess(true);
		// if (!log.excludeAll()) {
		// Map<String, String[]> pm = new HashMap<String, String[]>();
		// Set<String> es = new HashSet<String>();
		// java.util.Collections.addAll(es, log.exclude());
		// for (Object k : request.getParameterMap().keySet()) {
		// String key = (String) k;
		// if (!es.contains(key)) {
		// pm.put(key, request.getParameterValues(key));
		// }
		// }
		// String ps = JSONUtil.serialize(pm);
		// if (ps.length() > 2) {// {}
		// logs.setParam(new Content(UUID.randomUUID().toString(), ps));
		// }
		//
		// }
		// logs.setUri(request.getRequestURI().substring(request.getContextPath().length()));
		// if (request.getSession().getAttribute(Const.LOGIN_USER_SESSION_KEY)
		// == null) {
		// logs.setUserId(0L);
		// logs.setUserRealName("游客");
		// } else {
		// SessionUserVO user = (SessionUserVO)
		// request.getSession().getAttribute(Const.LOGIN_USER_SESSION_KEY);
		// logs.setUserId(user.getUserId());
		// logs.setUserRealName(user.getUserRealName());
		// }
		//
		// try {
		// ret = arg0.invoke();
		// } catch (Exception e) {
		// ex = e;
		// StringWriter out = new StringWriter();
		// PrintWriter pw = new PrintWriter(out);
		// e.printStackTrace(pw);
		// logs.setSuccess(false);
		// logs.setMsg(new Content(UUID.randomUUID().toString(),
		// out.toString()));
		//
		// }
		//
		// if (logs.getUserId() == 0 &&
		// request.getSession().getAttribute(Const.LOGIN_USER_SESSION_KEY) !=
		// null) {
		// SessionUserVO user = (SessionUserVO)
		// request.getSession().getAttribute(Const.LOGIN_USER_SESSION_KEY);
		// logs.setUserId(user.getUserId());
		// logs.setUserRealName(user.getUserRealName());
		// }
		//
		// service.add(logs);
		//
		// if (ex == null) {
		// return ret;
		// } else {
		// throw ex;
		// }
		//
		// } else {
		// return arg0.invoke();
		//
		// }

	}

}
