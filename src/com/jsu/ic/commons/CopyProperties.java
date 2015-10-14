package com.jsu.ic.commons;

/**
 * 相同属性拷贝完成后的处理
 * 
 * @author hadoop
 * 
 * @param <E>
 * @param <T>
 */
public interface CopyProperties<E, T> {

	/**
	 * 相同属性拷贝完成后的处理
	 * 
	 * @param sourceObject
	 * @param targetObject
	 * @param index
	 */
	void copy(E sourceObject, T targetObject, int index);
}
