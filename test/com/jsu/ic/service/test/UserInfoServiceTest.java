package com.jsu.ic.service.test;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jsu.ic.commons.Const;
import com.jsu.ic.po.User;
import com.jsu.ic.po.Userinfo;
import com.jsu.ic.service.UserInfoService;

public class UserInfoServiceTest {

	private static ApplicationContext context = null;
	private static UserInfoService service = null;
	private Userinfo entity;

	static {
		context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		service = (UserInfoService) context.getBean("userInfoService");
	}

	/**
	 * 测试添加用户详细信息
	 */
	@Test
	public void testSave() {
		entity = new Userinfo();
		entity.setUser(new User(1));
		entity.setIsDelete(false);
		entity.setBirthday(new Timestamp(new Date().getTime()));
		entity.setRegistTime(new Timestamp(new Date().getTime()));
		entity.setLoginNumber(0);
		entity.setLoginTime(new Timestamp(new Date().getTime()));
		entity.setSortNumber(0);
		entity.setLoginNumber(0);
		service.save(entity);
	}

	/**
	 * 测试获取某一时间段内的注册用户
	 */
	@Test
	public void testFindByDate() {
		Date endTime = Const.getDate();
		Date beginTime = new Date(endTime.getTime() - 1000 * 24 * 60 * 60);
		System.out.println(service.findByDate(beginTime, endTime).size());
	}

}
