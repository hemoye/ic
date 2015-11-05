package com.jsu.ic.service.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jsu.ic.service.KeyWordService;

public class KeyWordServiceTest {

	private static ApplicationContext context = null;
	private static KeyWordService service = null;

	static {
		context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		service = (KeyWordService) context.getBean("keyWordService");
	}

	/**
	 * 测试分页
	 */
	@Test
	public void testGetPageBean() {
		System.out.println(service.getPageBean(1, 10, null, null, "").getRecordCount());
	}
}
