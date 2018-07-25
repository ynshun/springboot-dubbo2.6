package com.ynshun.config.mybatis;

import com.ynshun.config.enums.DataSourceType;

/**
 * 本地线程，数据源上下文
 * 
 * @author ynshun
 * @since 2018年6月30日
 * @version 1.0
 */
public class DataSourceContextHolder {
	private static final ThreadLocal<String> local = new ThreadLocal<String>();

	public static ThreadLocal<String> getLocal() {
		return local;
	}

	/**
	 * 读库
	 * 
	 * @since 2018年6月30日
	 * @auth ynshun
	 * @version 1.0
	 */
	public static void setRead() {
		local.set(DataSourceType.read.getType());
	}

	/**
	 * 写库
	 * 
	 * @since 2018年6月30日
	 * @auth ynshun
	 * @version 1.0
	 */
	public static void setWrite() {
		local.set(DataSourceType.write.getType());
	}

	public static String getReadOrWrite() {
		return local.get();
	}

	public static void clear() {
		local.remove();
	}
}