package com.ynshun.config.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;

@Component
public class DubboBeanFactory {

	private static ApplicationConfig application;
	private static RegistryConfig registryConfig;

	@Autowired
	public void setApplicationConfig(ApplicationConfig application) {
		DubboBeanFactory.application = application;
	}

	@Autowired
	private void setRegistryConfig(RegistryConfig registryConfig) {
		DubboBeanFactory.registryConfig = registryConfig;
	}

	public static <T> T getDubboService(Class<T> interfaceClass) {
		// ApplicationConfig application = new ApplicationConfig();
		// application.setName(appName);
		// RegistryConfig registryConfig = new RegistryConfig();
		// registryConfig.setAddress(zookeeperUrl);

		ReferenceConfig<T> rc = new ReferenceConfig<T>();
		rc.setRegistry(registryConfig);
		rc.setApplication(application);
		rc.setInterface(interfaceClass);
		return rc.get();
	}

}
