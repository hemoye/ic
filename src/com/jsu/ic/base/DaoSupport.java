package com.jsu.ic.base;

import java.util.List;

import com.jsu.ic.commons.QueryHelper;
import com.jsu.ic.vo.PageBean;

/**
 * @author 木木
 * 
 */
public interface DaoSupport<T> {

	/**
	 * 运行SQL语句
	 * 
	 * @param sqlString
	 */
	public void runSQLString(String sqlString);

	/**
	 * 保存实体
	 * 
	 * @param entity
	 */
	public void save(T entity);

	/**
	 * 删除实体
	 * 
	 * @param entity
	 */
	public void delete(T entity);

	/**
	 * 更新实体
	 * 
	 * @param entity
	 */
	public void update(T entity);

	/**
	 * 按id查询
	 * 
	 * @param id
	 * @return T的实体
	 */
	public T findById(Integer id);

	/**
	 * 按id查询
	 * 
	 * @param ids
	 * @return T实体的集合
	 */
	public List<T> findByIds(Integer[] ids);

	/**
	 * 根据某一个属性来查找
	 * 
	 * @param propertyName
	 * @param value
	 * @return T实体的集合
	 */
	public List<T> findByProperty(String propertyName, Object value);

	/**
	 * 根据某一个属性来查找
	 * 
	 * @param propertyName
	 * @param value
	 * @return T实体的集合
	 */
	public T findByProperty(String propertyName, String value);

	/**
	 * 查询所有
	 * 
	 * @return T实体的集合
	 */
	public List<T> findAll();

	/**
	 * 公共的查询分页信息的方法
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param queryHelper
	 *            HQL语句与参数列表
	 * @return
	 */
	public PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);

}
