package com.jsu.ic.commons;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AutoValue implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("test");
	}


}
