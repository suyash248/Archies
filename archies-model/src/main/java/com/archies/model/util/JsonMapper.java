package com.archies.model.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

@SuppressWarnings("serial")
public class JsonMapper extends ObjectMapper  implements ApplicationContextAware{
	
	private static ApplicationContext applicationContext;
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		JsonMapper.applicationContext = applicationContext;
	}	
	
	public JsonMapper(){
		super();
		registerModule(new Hibernate4Module());
		configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
		configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
	}
	
	public static JsonMapper getMapper(){
		return applicationContext.getBean(JsonMapper.class);
	}

}
