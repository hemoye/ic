package com.jsu.ic.service.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jsu.ic.commons.Const;
import com.jsu.ic.service.SysLogService;

public class SysLogServiceTest {

	private static ApplicationContext context = null;
	private static SysLogService service = null;

	static {
		context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		service = (SysLogService) context.getBean("sysLogService");
	}

	/**
	 * 测试某一段时间内的访问记录
	 */
	@Test
	public void testFindByDate() {
		Date beginTime = Const.getDate();
		Date endTime = new Date(beginTime.getTime() + 1000 * 24 * 60 * 60);
		System.out.println(service.findByDate(beginTime, endTime).size());
	}

}
