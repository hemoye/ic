package com.jsu.ic.commons;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.jsu.ic.annotation.PO2VO;

public class BeanTools {

	/**
	 * 对列表进行排序
	 * 
	 * @param list
	 * @param columnName
	 *            需要排序的字段名称，必须为数字类型，默认为 "sortNumber"
	 * @param isAsc
	 *            是否按升序排列 默认为 true
	 */
	public static void sort(List<? extends Object> list, String columnName, boolean isAsc) {
		java.util.Collections.sort(list, new Sort(columnName, isAsc));

	}

	public static void sort(List<? extends Object> list, boolean isAsc) {
		java.util.Collections.sort(list, new Sort(isAsc));
	}

	public static void sort(List<? extends Object> list, String columnName) {
		java.util.Collections.sort(list, new Sort(columnName));
	}

	public static void sort(List<? extends Object> list) {
		java.util.Collections.sort(list, new Sort());
	}

	/**
	 * 随机排列
	 * 
	 * @param list
	 */
	public static void sortRandom(List<? extends Object> list) {
		java.util.Collections.sort(list, new SortRandom());
	}

	/**
	 * 对象属性拷贝
	 * 
	 * @param sourceObject
	 *            源对象
	 * @param targetObject
	 *            目标对象
	 * @param ignoreProperties
	 *            忽略掉的属性
	 */
	public static <E, T> void copyProperties(E sourceObject, T targetObject, String... ignoreProperties) {
		BeanUtils.copyProperties(sourceObject, targetObject, ignoreProperties);
		if (targetObject.getClass().isAnnotationPresent(PO2VO.class)) {
			PO2VO po2vo = targetObject.getClass().getAnnotation(PO2VO.class);
			if (po2vo.po().equals(Object.class) || sourceObject.getClass().equals(po2vo.po())) {
				for (String fieldName : po2vo.value()) {
					try {
						Object temp = getFieldValue(sourceObject, fieldName);
						if (temp != null) {
							BeanUtils.copyProperties(temp, targetObject, ignoreProperties);
						}
					} catch (Exception e) {
						e.printStackTrace();
						throw new RuntimeException("复制PO对象的属性到VO中错误:" + fieldName, e);
					}
				}
			}
		}
	}

	private static Object getFieldValue(Object obj, String fieldNames) throws Exception {
		if (fieldNames.indexOf(".") > -1) {
			String fieldName = fieldNames.substring(0, fieldNames.indexOf("."));
			fieldNames = fieldNames.substring(fieldNames.indexOf(".") + 1);
			Field field = obj.getClass().getDeclaredField(fieldName);
			boolean accessible = field.isAccessible();
			field.setAccessible(true);
			Object temp = field.get(obj);
			field.setAccessible(accessible);
			if (temp == null) {
				return null;
			}
			return getFieldValue(temp, fieldNames);
		} else {
			Field field = obj.getClass().getDeclaredField(fieldNames);
			boolean accessible = field.isAccessible();
			field.setAccessible(true);
			Object temp = field.get(obj);
			field.setAccessible(accessible);
			return temp;
		}

	}

	/**
	 * 拷贝集合对象
	 * 
	 * @param sourceList
	 *            源集合
	 * @param targetObject
	 *            目标对象,该对象必须有无参构造方法
	 * @param copyProperties
	 *            拷贝属性后的处理
	 * @param ignoreProperties
	 *            忽略掉的属性
	 * @return 目标对象的列表
	 */
	public static <E, T> List<T> copyProperties(Collection<E> sourceList, T targetObject, CopyProperties<E, T> copyProperties,
			String... ignoreProperties) {
		try {
			int index = 0;
			List<T> list = new ArrayList<T>();
			for (E e : sourceList) {
				@SuppressWarnings("unchecked")
				T newObject = ((T) targetObject.getClass().newInstance());
				copyProperties(e, newObject, ignoreProperties);
				if (copyProperties != null) {
					copyProperties.copy(e, newObject, index);
				}
				list.add(newObject);
				++index;
			}
			return list;
		} catch (Exception e) {
			throw new RuntimeException("拷贝对象属性失败", e);
		}
	}

	/**
	 * 拷贝集合对象
	 * 
	 * @param sourceList
	 *            源集合
	 * @param targetObject
	 *            目标对象
	 * @param ignoreProperties
	 *            忽略掉的属性
	 * @return 目标对象的列表
	 */
	public static <E, T> List<T> copyProperties(Collection<E> sourceList, T targetObject, String... ignoreProperties) {
		return copyProperties(sourceList, targetObject, null, ignoreProperties);
	}

}
