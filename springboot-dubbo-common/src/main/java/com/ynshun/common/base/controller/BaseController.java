package com.ynshun.common.base.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ynshun.common.data.MapData;
import com.ynshun.common.util.TypeUtil;

/**
 * @description:
 *
 * @createdTime: 2017年11月30日 下午5:13:25
 * @createdUser: ynshun
 * @version: 1.0
 */
public class BaseController implements EnvironmentAware {
	protected Environment environment;

	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	protected String getConfig(String propertyKey) {
		return environment.getProperty(propertyKey);
	}

	protected Integer getIntConfig(String propertyKey) {
		return environment.getProperty(propertyKey, Integer.class);
	}

	protected String getParameter(String parameterName) {
		return this.getRequest().getParameter(parameterName);
	}

	protected MapData getParameters() {
		MapData mapData = MapData.getInstance();
		// 封装前端传递参数
		Enumeration<String> names = this.getRequest().getParameterNames();
		String name;
		while (names.hasMoreElements()) {
			name = names.nextElement();
			mapData.put(name, this.getParameter(name));
		}

		return mapData;
	}

	protected <T> T getParameter(String parameterName, Class<T> targetType) {
		return TypeUtil.transfer(this.getParameter(parameterName), targetType);
	}

	protected HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	protected HttpServletResponse getResponse() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
	}

	protected HttpSession getSession() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
	}

}