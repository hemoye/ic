package com.jsu.ic.service.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jsu.ic.po.Power;
import com.jsu.ic.po.Userrole;
import com.jsu.ic.service.PowerService;

public class PowerServiceTest {

	private static ApplicationContext context = null;
	private static PowerService service = null;

	static {
		context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		service = (PowerService) context.getBean("powerService");
	}

	@Test
	public void testFindAll() {
		System.out.println(service.findAll().size());
	}

	@Test
	public void testFindByRole() {
		for (Power power : service.findByRole(new Userrole(1))) {
			System.out.println(power.getPowerName());
		}
	}

}
