package com.jsu.ic.interceptor;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.jsu.ic.annotation.AutoAttr;
import com.jsu.ic.annotation.AutoAttr.Scope;
import com.jsu.ic.annotation.AutoUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 自动设置登陆用户和各作用域中的属性<br/>
 * 
 * 自动设置登陆用户有两种形式： <br/>
 * IOC:SessionUserAware <br/>
 * annotation:AutoUser 字段<br/>
 * 
 * @author hadoop
 * 
 */
@SuppressWarnings("serial")
public class AutoAttrAndSessionUserInterceptor implements Interceptor {

	private Map<Class<?>, List<Field>> users = new HashMap<Class<?>, List<Field>>(0);
	private Map<Class<?>, List<Field>> attrs = new HashMap<Class<?>, List<Field>>(0);

	@Override
	public void destroy() {
	}

	@Override
	public void init() {
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		Object action = arg0.getAction();
		// SessionUserVO user = (SessionUserVO)
		// ServletActionContext.getRequest()
		// .getSession().getAttribute(Const.LOGIN_USER_SESSION_KEY);
		if (action instanceof SessionUserAware) {
			SessionUserAware sessionUser = (SessionUserAware) action;
			// sessionUser.setUser(user);
		}
		if (users.get(action.getClass()) == null) {
			users.put(action.getClass(), getUser(action));
		}
		for (Field f : users.get(action.getClass())) {
			boolean isAccessible = f.isAccessible();
			f.setAccessible(true);
			// f.set(action, user);
			f.setAccessible(isAccessible);

		}
		if (attrs.get(action.getClass()) == null) {
			attrs.put(action.getClass(), getAttr(action));
		}
		for (Field f : attrs.get(action.getClass())) {
			boolean isAccessible = f.isAccessible();
			AutoAttr attr = f.getAnnotation(AutoAttr.class);
			Scope scope = attr.scope();
			String name = attr.value() == null || "".equals(attr.value()) ? f.getName() : attr.value();
			Object value = null;
			switch (scope) {
			case REQUEST:
				value = ServletActionContext.getRequest().getAttribute(name);
				break;

			case SESSION:
				value = ActionContext.getContext().getSession().get(name);
				break;

			case APPLICATION:
				value = ActionContext.getContext().getParameters().get(name);
				break;

			case PARAM:
				value = ServletActionContext.getRequest().getParameter(name);
				break;

			case PARAMS:
				value = ServletActionContext.getRequest().getParameterValues(name);
				break;

			default:
				value = ActionContext.getContext().get(name);
				break;
			}
			f.setAccessible(true);
			f.set(action, value);
			f.setAccessible(isAccessible);

		}
		return arg0.invoke();
	}

	/**
	 * 获取需要设置属性的字段
	 * 
	 * @param obj
	 * @return
	 */
	public List<Field> getAttr(Object obj) {
		List<Field> list = new ArrayList<Field>(0);
		for (Field f : obj.getClass().getDeclaredFields()) {
			if (f.isAnnotationPresent(AutoAttr.class)) {
				list.add(f);
			}
		}
		return list;
	}

	public List<Field> getUser(Object obj) {
		List<Field> list = new ArrayList<Field>(0);
		for (Field f : obj.getClass().getDeclaredFields()) {
			if (f.isAnnotationPresent(AutoUser.class)) {
				list.add(f);
			}
		}
		return list;
	}
}
