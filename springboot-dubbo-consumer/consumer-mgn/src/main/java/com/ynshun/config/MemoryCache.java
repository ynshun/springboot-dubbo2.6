package com.ynshun.config;

import com.ynshun.common.domain.system.SystemEmployee;

public class MemoryCache {

	public static SystemEmployee currentEmployee() {
		SystemEmployee currentEmployee = new SystemEmployee();
		currentEmployee.setId(1);
		currentEmployee.setName("余能顺");
		return currentEmployee;
	}
}
