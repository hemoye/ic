package com.jsu.ic.commons;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jsu.ic.exception.CodeException;


/**
 * 日期转换工具
 * 
 * @author hadoop
 */

public class DateConvert {

	private static Format formats = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static Format format = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * 将Date类型转换成字符串
	 */
	public String toString(Object object) {
		if (object == null) {
			return "null";
		}
		return formats.format(object);
	}

	public static String datetoString(Object object) {
		if (object == null) {
			return "null";
		}
		return formats.format(object);
	}

	/**
	 * 将字符串转换成Date类型
	 */
	public static Date fromString(String value) {
		try {
			if ("null".equals(value)) {
				return null;
			}
			try {
				return (Date) formats.parseObject(value);
			} catch (Exception e) {
				return (Date) format.parseObject(value);
			}
		} catch (Exception e) {
			throw new CodeException(1, "将字符串转换为当前日期类型出错");
		}
	}

	public static Date stringtoDate(String value) {
		try {
			if ("null".equals(value)) {
				return null;
			}
			try {
				return (Date) formats.parseObject(value);
			} catch (Exception e) {
				return (Date) format.parseObject(value);
			}
		} catch (Exception e) {
			throw new CodeException(1, "将字符串转换为当前日期类型出错");
		}
	}

}