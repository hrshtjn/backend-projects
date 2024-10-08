package com.demo.struts.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.logging.log4j.LogManager;

public class Log4j2InitListener implements ServletContextListener{
	
	public void contextInitialized(ServletContextEvent event) {
        // Log4j 2 will automatically configure itself if log4j2.xml is in the classpath
        LogManager.getLogger(Log4j2InitListener.class).info("Log4j 2 initialized.");
    }

    public void contextDestroyed(ServletContextEvent event) {
        // Do nothing
    }

}
