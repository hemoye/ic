package com.jsu.ic.base;

import java.lang.reflect.ParameterizedType;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author 木木
 * 
 */

@SuppressWarnings("serial")
public abstract class MyActionSupport<T> extends ActionSupport implements ModelDriven<T> {

	// =============== ModelDriven的支持 ==================
	protected T model;

	@SuppressWarnings("unchecked")
	public MyActionSupport() {
		try {
			// 通过反射获取model的真实类型
			ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
			// 通过反射创建model的实例
			model = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public T getModel() {
		return model;
	}

	// =============== Service实例的声明 ==================

	/**
	 * 获取当前登录的用户
	 * 
	 * @return 当前登录的用户实体
	 */
	// protected User getCurrentUser() {
	// return (User)
	// ActionContext.getContext().getSession().get(PublicSession.USER);
	// }

	// ============== 分页用的参数 =============

	protected int pageNum = 1; // 当前页
	protected int pageSize = 10; // 每页显示多少条记录

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
