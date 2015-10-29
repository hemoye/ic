package com.jsu.ic.commons;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jsu.ic.po.Head;
import com.jsu.ic.po.Posttype;
import com.jsu.ic.po.Power;
import com.jsu.ic.po.Resourcetype;
import com.jsu.ic.po.User;
import com.jsu.ic.po.Userinfo;
import com.jsu.ic.po.Useroffice;
import com.jsu.ic.po.Userrole;
import com.jsu.ic.service.CityService;
import com.jsu.ic.service.HeadService;
import com.jsu.ic.service.PostTypeService;
import com.jsu.ic.service.PowerService;
import com.jsu.ic.service.ResourceTypeService;
import com.jsu.ic.service.UserInfoService;
import com.jsu.ic.service.UserOfficeService;
import com.jsu.ic.service.UserRoleService;
import com.jsu.ic.service.UserService;

/**
 * 自动注入基础数据
 * 
 * @author hadoop
 * 
 */

public class AutoValue implements ServletContextListener {

	private static ApplicationContext context = null;

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		initData(sce);
	}

	@SuppressWarnings("unchecked")
	public void initData(ServletContextEvent sce) {
		Logger.getLogger(Const.class).debug("系统基础检测...");

		Properties jdbc = Const.config;
		if (jdbc.getProperty("init").equals("0")) {
			Logger.getLogger(Const.class).debug("检测到当前为首次使用系统、开始自动加载基础数据");

			context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
			try {
				// 加载地址信息
				File db = new File("config/database/city.sql");
				BufferedReader bufferedReader = new BufferedReader(new FileReader(db));
				String sqlString = null;
				while ((sqlString = bufferedReader.readLine()) != null) {
					CityService cityService = (CityService) context.getBean("cityService");
					cityService.runSQLString(sqlString);
				}
				// 加载权限
				PowerService powerService = (PowerService) context.getBean("powerService");
				Power power = new Power();
				power.setIsDelete(false);
				power.setSortNumber(0);
				SAXReader saxReader = new SAXReader(); // 获取XML读取器
				Document document = saxReader.read(new File("config/database/power.xml"));
				Element root = document.getRootElement();

				List<Element> powers = root.elements(); // 获取二级元素列表
				for (Element element : powers) {
					power.setPowerName(element.elementText("name"));
					power.setPowerUrl(element.elementText("url"));
					if (!element.elementText("father").equals("0")) {
						power.setPower(powerService.findByProperty("powerName", element.elementText("father")));
					}
					power.setAddTime(new Timestamp(new Date().getTime()));
					power.setUpdateTime(new Timestamp(new Date().getTime()));
					powerService.save(power);
				}

				// 加载用户角色、并分配权限
				saxReader.read(new File("config/database/role.xml"));
				UserRoleService userRoleService = (UserRoleService) context.getBean("userRoleService");
				Userrole role = new Userrole();
				role.setIsDelete(false);
				role.setSortNumber(0);

				List<Element> roles = root.elements(); // 获取二级元素列表
				for (Element element : roles) {
					role.setRoleName(element.elementText("name"));
					List<Element> rolePowers = element.elements("powers");
					Set<Power> powerSet = new HashSet<Power>();
					for (Element rolePower : rolePowers) {
						powerSet.add(powerService.findByProperty("name", rolePower.elementText("name")));
					}
					role.setPowers(powerSet);
					role.setAddTime(new Timestamp(new Date().getTime()));
					role.setUpdateTime(new Timestamp(new Date().getTime()));
					userRoleService.save(role);
				}

				// 加载用户信息、同时配置用户详细信息
				UserService userService = (UserService) context.getBean("userService");
				UserInfoService userInfoService = (UserInfoService) context.getBean("userInfoService");
				User user = new User();
				Userinfo userinfo = new Userinfo();
				user.setUserrole(userRoleService.findByProperty("roleName", "超级管理员"));
				user.setUserName("admin");
				user.setUserPwd(MD5.MD5Encode("admin"));
				user.setSortNumber(0);
				user.setIsDelete(false);
				user.setStatus(1);
				user.setFrostTime(new Timestamp(new Date().getTime()));
				userService.save(user);

				userinfo.setUser(user);
				userinfo.setBirthday(new Timestamp(new Date().getTime()));
				userinfo.setSortNumber(0);
				userinfo.setIsDelete(false);
				userinfo.setLoginNumber(0);
				userinfo.setLoginTime(new Timestamp(new Date().getTime()));
				userinfo.setRegistTime(new Timestamp(new Date().getTime()));
				userInfoService.save(userinfo);

				for (int i = 0; i < 200; i++) {
					user.setUserName("test" + i);
					user.setUserPwd(MD5.MD5Encode("test"));
					user.setUserrole(userRoleService.findByProperty("roleName", "普通用户"));
					userService.save(user);
					userinfo.setUser(user);
					userInfoService.save(userinfo);
				}

				// 加载系统头像信息
				HeadService headService = (HeadService) context.getBean("headService");
				Head head = new Head();
				head.setAddTime(new Timestamp(new Date().getTime()));
				head.setUpdateTime(new Timestamp(new Date().getTime()));
				head.setIsDelete(false);
				head.setSortNumber(0);
				for (int i = 1; i <= 8; i++) {
					head.setHeadUrl("front/img/" + i + ".jpg");
					headService.save(head);
				}

				// 加载职位
				saxReader.read(new File("config/database/office.xml"));
				UserOfficeService userOfficeService = (UserOfficeService) context.getBean("userOfficeService");
				Useroffice useroffice = new Useroffice();
				useroffice.setIsDelete(false);
				useroffice.setSortNumber(0);

				List<Element> offices = root.elements(); // 获取二级元素列表
				for (Element element : offices) {
					useroffice.setOfficeName(element.elementText("name"));
					useroffice.setAddTime(new Timestamp(new Date().getTime()));
					useroffice.setUpdateTime(new Timestamp(new Date().getTime()));
					userOfficeService.save(useroffice);
				}

				// 加载帖子类型
				saxReader.read(new File("config/database/posttype.xml"));
				PostTypeService postTypeService = (PostTypeService) context.getBean("postTypeService");
				Posttype posttype = new Posttype();
				posttype.setIsDelete(false);
				posttype.setSortNumber(0);

				List<Element> posttypes = root.elements(); // 获取二级元素列表
				for (Element element : posttypes) {
					posttype.setTypeName((element.elementText("name")));
					posttype.setAddTime(new Timestamp(new Date().getTime()));
					posttype.setUpdateTime(new Timestamp(new Date().getTime()));
					postTypeService.save(posttype);
				}

				// 加载资源类型
				saxReader.read(new File("config/database/resourcetype.xml"));
				ResourceTypeService resourceTypeService = (ResourceTypeService) context.getBean("resourceTypeService");
				Resourcetype resourcetype = new Resourcetype();
				resourcetype.setIsDelete(false);
				resourcetype.setSortNumber(0);

				List<Element> resourcetypes = root.elements(); // 获取二级元素列表
				for (Element element : resourcetypes) {
					resourcetype.setTypeName((element.elementText("name")));
					resourcetype.setAddTime(new Timestamp(new Date().getTime()));
					resourcetype.setUpdateTime(new Timestamp(new Date().getTime()));
					resourceTypeService.save(resourcetype);
				}

				jdbc.setProperty("init", "1");
				jdbc.store(new FileWriter(new File("config/jdbc.properties")), null);
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}

		Logger.getLogger(Const.class).debug("检测完成");
	}
}
