package com.jsu.ic.service.test;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jsu.ic.commons.MD5;
import com.jsu.ic.po.User;
import com.jsu.ic.service.UserService;

public class UserServiceTest {

	private static ApplicationContext context = null;
	private static UserService service = null;
	private User entity;

	static {
		context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		service = (UserService) context.getBean("userService");
	}

	/**
	 * 测试添加用户
	 */
	@Test
	public void testSave() {
		entity = new User();
		entity.setUserName("admin");
		entity.setUserPwd(MD5.MD5Encode("admin"));
		entity.setFrostTime(new Timestamp(new Date().getTime()));
		entity.setIsDelete(false);
		entity.setSortNumber(0);
		service.save(entity);
	}

	/**
	 * 测试登陆
	 * 
	 * @throws Exception
	 */
	@Test
	public void testLogin() throws Exception {
		User user = service.login("admin", "admin");
		System.out.println(user);
	}

	/**
	 * 测试查询所有用户
	 */
	@Test
	public void testFindAll() {
		System.out.println(service.findAll().size());
	}

	/**
	 * 测试分页
	 */
	@Test
	public void testGetPageBean() {
		System.out.println(service.getPageBean(1, 10, null, null, "", 0).getEndPageIndex());
	}
}
