package com.jsu.ic.service.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jsu.ic.service.UserRoleService;

public class UserRoleServiceTest {

	private static ApplicationContext context = null;
	private static UserRoleService service = null;

	static {
		context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		service = (UserRoleService) context.getBean("userRoleService");
	}
	
	@Test
	public void testFindById() {
		System.out.println(service.findById(1).getPowers().size());
	}

}
