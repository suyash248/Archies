package com.archies.service.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SpringUtil implements ApplicationContextAware {
	private static ApplicationContext applicationContext;
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringUtil.applicationContext = applicationContext;
		
		// set the security context holder strategy to 'Inheritable ThreadLocal'
		// This needs to be set only once per JVM. 
		// This is necessary so that child threads inherit the same security context of the parent threads
		SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
	}
	
	public static <T> T getBean(Class<T> requiredType){
		return applicationContext.getBean(requiredType);
	}
	
	public static <T> T getBean(String name, Class<T> requiredType){
		return applicationContext.getBean(name, requiredType);
	}
}
