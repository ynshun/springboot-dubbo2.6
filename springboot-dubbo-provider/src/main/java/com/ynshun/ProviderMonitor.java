package com.ynshun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

@SpringBootApplication
@EnableDubboConfiguration
public class ProviderMonitor {
	
	public static void main(String[] args) {
		SpringApplication.run(ProviderMonitor.class, args);
	}
}