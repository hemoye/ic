package com.jsu.ic.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自动注入属性
 * 
 * @author hadoop
 * 
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface AutoAttr {

	public enum Scope {
		ACTION, REQUEST, SESSION, APPLICATION, PARAM, PARAMS;
	}

	/**
	 * 操作的作用域
	 * 
	 * @return
	 */
	Scope scope() default Scope.REQUEST;

	/**
	 * 属性名称
	 * 
	 * @return
	 */
	String value();

}
