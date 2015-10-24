package com.jsu.ic.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.jsu.ic.commons.QueryHelper;
import com.jsu.ic.vo.PageBean;
/**
 * @author 木木
 *
 */

@SuppressWarnings("unchecked")
@Transactional
public abstract class DaoSupportImpl<T> implements DaoSupport<T> {

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	private Class<T> clazz;
	protected Logger log;

	/**
	 * 使用反射技术得到T的真实类型
	 */
	public DaoSupportImpl() {
		// 1、获取当前new的对象的 泛型的父类 类型
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass(); 
		// 2、获取第一个类型参数的真实类型
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0]; 
		log = LoggerFactory.getLogger(this.getClass());
	}
	
	/**
	 * 获取当前可用的session
	 * @return session
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(T entity) {
		log.debug("saving " + clazz + " instance");
		try {
			getSession().save(entity);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(T entity) {
		log.debug("deleting " + clazz + " instance");
		try {
			getSession().delete(entity);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	@Override
	public void update(T entity) {
		log.debug("update " + clazz + " instance");
		try {
			getSession().update(entity);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	@Override
	public T findById(Integer id) {
		log.debug("getting " + clazz + " instance with id: " + id);
		try {
			if (null == id) {
				log.error("get failed" + " the id is null");
				return null;
			}
			return (T) getSession().get(clazz, id);
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	@Override
	public List<T> findByIds(Integer[] ids) {
		log.debug("getting " + clazz + " instance with ids: " + ids);
		try {
			if (null == ids || 0 == ids.length) {
				log.error("get failed" + " the ids is null or the ids.length is zero");
				return Collections.EMPTY_LIST;
			}
			else {
				return getSession().createQuery(
						"from " + clazz.getSimpleName() + " where id in (:ids)")
						.setParameterList("ids", ids).list();
			}
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<T> findByProperty(String propertyName, Object value) {
		log.debug("finding " + clazz + " instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from " + clazz.getSimpleName() + " as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@Override
	public List<T> findAll() {
		log.debug("finding all " + clazz + " instances");
		try {
			String queryString = "from " + clazz.getSimpleName();
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("rawtypes")
	public PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper) {
		// 参数列表
		List<Object> parameters = queryHelper.getParameters();
		// 查询本页的数据列表
		Query listQuery = getSession().createQuery(queryHelper.getListQueryHql()); // 创建查询对象
		if (parameters != null) { // 设置参数
			for (int i = 0; i < parameters.size(); i++) {
				listQuery.setParameter(i, parameters.get(i));
			}
		}
		listQuery.setFirstResult((pageNum - 1) * pageSize);
		listQuery.setMaxResults(pageSize);
		List list = listQuery.list(); // 执行查询

		// 查询总记录数量
		Query countQuery = getSession().createQuery(queryHelper.getCountQueryHql());
		if (parameters != null) { // 设置参数
			for (int i = 0; i < parameters.size(); i++) {
				countQuery.setParameter(i, parameters.get(i));
			}
		}
		Long count = (Long) countQuery.uniqueResult(); // 执行查询

		return new PageBean(pageNum, pageSize, count.intValue(), list);
	}
}
