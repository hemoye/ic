package com.jsu.ic.service.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jsu.ic.commons.Const;
import com.jsu.ic.service.SchoolService;

public class SchoolServiceTest {

	private static ApplicationContext context = null;
	private static SchoolService service = null;

	static {
		context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		service = (SchoolService) context.getBean("schoolService");
	}

	/**
	 * 测试某一段时间内的认证的学校记录
	 */
	@Test
	public void testFindByDate() {
		Date endTime = Const.getDate();
		Date beginTime = new Date(endTime.getTime() + 1000 * 24 * 60 * 60);
		System.out.println(service.findByDate(endTime, beginTime).size());
	}

}
