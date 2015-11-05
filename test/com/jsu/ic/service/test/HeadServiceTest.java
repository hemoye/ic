package com.jsu.ic.service.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jsu.ic.service.HeadService;

public class HeadServiceTest {

	private static ApplicationContext context = null;
	private static HeadService service = null;

	static {
		context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		service = (HeadService) context.getBean("headService");
	}

	/**
	 * 测试分页
	 */
	@Test
	public void testGetPageBean() {
		System.out.println(service.getPageBean(1, 10, null, null).getRecordCount());
	}
}
