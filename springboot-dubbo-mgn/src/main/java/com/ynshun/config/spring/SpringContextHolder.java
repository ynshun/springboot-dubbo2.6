package com.ynshun.config.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextHolder implements ApplicationContextAware {
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextHolder.applicationContext = applicationContext;
	}
	
	/**
	 * @return the applicationContext
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * 根据Class获取Bean
	 * @description: 
	 * @param clazz
	 * @return
	 * @createdTime: 2016年11月8日 下午4:05:02
	 * @createdUser: ynshun
	 * @lastUpdatedTime:
	 * @lastUpdatedUser:
	 * @version: 1.0
	 */
	public static <T> T getBean(Class<T> clazz) {
		return applicationContext.getBean(clazz);
	}

	/**
	 * 根据Bean Name和Class获取Bean
	 * @description: 
	 * @param name
	 * @param clazz
	 * @return
	 * @createdTime: 2016年11月8日 下午4:05:21
	 * @createdUser: ynshun
	 * @lastUpdatedTime:
	 * @lastUpdatedUser:
	 * @version: 1.0
	 */
	public static <T> T getBean(String name, Class<T> clazz) {
		return applicationContext.getBean(name, clazz);
	}

	/**
	 * 根据Bean Name获取Bean
	 * @description: 
	 * @param name
	 * @return
	 * @createdTime: 2016年11月8日 下午4:05:41
	 * @createdUser: ynshun
	 * @lastUpdatedTime:
	 * @lastUpdatedUser:
	 * @version: 1.0
	 */
	public static Object getBean(String name) {
		return applicationContext.getBean(name);
	}

}
