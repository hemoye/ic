package com.jsu.ic.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 将PO对象转化为VO对象
 * 
 * @author hadoop
 * 
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface PO2VO {

	/**
	 * 检查传入的对象的类型（转换的源对象类型）
	 * 
	 * @return
	 */
	Class<? extends Object> po() default Object.class;

	/**
	 * 需要复制的属性对象
	 * 
	 * @return
	 */
	String[] value();
}
