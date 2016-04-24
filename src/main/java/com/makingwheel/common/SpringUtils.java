package com.makingwheel.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringUtils implements ApplicationContextAware{

	private static ApplicationContext applicationContext;
	
	public static Object getBean(Class<?> clazz){
		//WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		return applicationContext.getBean(clazz);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringUtils.applicationContext = applicationContext;
	}
	
}
