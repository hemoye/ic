package com.jsu.ic.commons;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 常量公共类<br/>
 * 注意系统时间必须由这个类里面取得<br/>
 * 声明可以配置的常量不要加final,常量可以再config配置文件中改变，常量类型请不要使用基本数据类型
 * 
 * @author hadoop
 * 
 */
public final class Const {

	/**
	 * 登陆用户的SESSION KEY
	 */
	public static String LOGIN_USER_SESSION_KEY = "LOGIN_USER_SESSION_KEY";

	/**
	 * 配置文件对象
	 */
	public static final Properties config = new Properties();

	/**
	 * 测试时，默认登陆的账户账户
	 */
	public static Integer TEST_USER_ID = 1;

	/**
	 * 短URL后缀名
	 */
	public static String SHORT_URL_EXT = ".html";

	/**
	 * 通过参数传递的sessionid的名称
	 */
	public static String SESSION_ID_NAME = "sessionId";

	/**
	 * 模块名称的检测正则 $1 //有待改进
	 */
	public static String MODULE_REGX = "^/manage/(.+)$";

	/**
	 * 文件保存根目录<br/>
	 * %WEB_ROOT%表示网站根目录<br/>
	 * 使用getFileRoot()获取
	 */
	private static String FILE_ROOT = "%WEB_ROOT%/WEB-INF/";

	/**
	 * 网站目录<br/>
	 * 在web容器下会自动设置成当前网站路径<br/>
	 * 默认值：c:\
	 */
	public static String WEB_ROOT = "c:\\";

	/**
	 * 临时文件定时清理时间 单位分钟
	 */
	public static Integer TEMP_FILE_CLEAR_TIME = 60;

	/**
	 * 获取配置信息
	 * 
	 * @return
	 */
	public final static Properties getConfig() {
		return config;
	}

	/**
	 * 获取文件存放根目录
	 * 
	 * @return
	 */
	public final static String getFileRoot() {
		return FILE_ROOT.replaceAll("%WEB_ROOT%", WEB_ROOT);
	}

	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public final static Date getDate() {
		return new Date();
	}

	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public final static Calendar getCalendar() {
		return Calendar.getInstance();
	}

	/**
	 * 从配置文件中装置常量的值
	 */
	static {
		try {
			config.load(new FileReader(new File("G:/Code/GZ/ic/config/jdbc.properties")));
			for (Field f : Const.class.getDeclaredFields()) {
				setValue(f, config.getProperty(f.getName()));
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	/**
	 * 设置类的属性
	 * 
	 * @param f
	 * @param value
	 * @throws Exception
	 */
	public static void setValue(Field f, String value) {
		try {
			if ((!Modifier.isFinal(f.getModifiers())) && value != null) {
				f.setAccessible(true);
				if (f.getType() == String.class) {
					f.set(null, value);
				} else {
					f.set(null, f.getType().getMethod("valueOf", String.class).invoke(null, value));
				}

				f.setAccessible(false);
				Logger.getLogger(Const.class).debug("成功装载了常量：" + f.getName() + "=" + f.get(null));
			}
		} catch (Exception e) {
			Logger.getLogger(Const.class).warn("未能装载常量：" + f.getName() + ",希望装载：" + value, e);
		}
	}

}