package com.jsu.ic.test;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hadoop
 * 
 */
public class TestSpring {

	private ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

	/**
	 * 测试整合spring
	 */
	@Test
	public void testBean() {
		TestStrutsAction testStrutsAction = (TestStrutsAction) context.getBean("testStrutsAction");
		System.out.println(testStrutsAction);
	}

	/**
	 * 测试整合Hibernate
	 */
	@Test
	public void testSessionFactory() {
		SessionFactory factory = (SessionFactory) context.getBean("sessionFactory");
		System.out.println(factory);
	}
	
}
