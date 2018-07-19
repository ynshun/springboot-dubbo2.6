package com.ynshun.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class PropertiesUtil {
	private static final String profile = "config/profile.properties";

	private static Properties properties = new Properties();

	/**
	 * 读取properties配置文件信息
	 */
	static {
		try {
			properties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(profile));

			String activeProfile = properties.getProperty("active.profile");

			String activeConfig = "config/" + activeProfile + "/config.properties";

			properties.clear();

			InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream(activeConfig);

			properties.load(new InputStreamReader(in, "UTF-8"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据key得到value的值
	 */
	public static String getString(String key) {
		return getString(key, null);
	}
	
	/**
	 * 根据key获取value值，若值为空则使用默认值
	 * 
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static String getString(String key, String defaultValue) {
		String value = properties.getProperty(key);
		return StringUtils.isNotBlank(value) ? value : defaultValue;
	}

	/**
	 * 根据key得到value的值
	 * 
	 * @param key
	 * @param type
	 * @return
	 */
	public static <T> T getValue(String key, Class<T> type) {
		return getValue(key, type, null);
	}

	/**
	 * 根据key获取value值，若值为空则使用默认值
	 * 
	 * @param key
	 * @param type
	 * @param defaultValue
	 * @return
	 */
	public static <T> T getValue(String key, Class<T> type, T defaultValue) {
		T value = getValue(key, type);
		return value == null ? defaultValue : value;
	}

}
