package com.ynshun.common.config.mybatis;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 数据库源配置
 * 
 * @author ynshun
 * @since 2018年6月30日
 * @version 1.0
 */
@Configuration
public class DataSourceConfiguration {
	private static Logger log = LoggerFactory.getLogger(DataSourceConfiguration.class);

	@Value("${mysql.datasource.type}")
	private Class<? extends DataSource> dataSourceType;

	/**
	 * 写库 数据源配置
	 * 
	 * @since 2018年6月30日
	 * @auth ynshun
	 * @version 1.0
	 * @return
	 */
	@Primary
	@Bean(name = "writeDataSource")
	@ConfigurationProperties(prefix = "mysql.datasource.write")
	public DataSource writeDataSource() {
		log.info("-------------------- writeDataSource init ---------------------");
		return DataSourceBuilder.create().type(dataSourceType).build();
	}

	/**
	 * 从库1配置
	 * 
	 * 		（有多少个从库就要配置多少个）
	 * 
	 * @since 2018年6月30日
	 * @auth ynshun
	 * @version 1.0
	 * @return
	 */
	@Bean(name = "readDataSource01")
	@ConfigurationProperties(prefix = "mysql.datasource.read01")
	public DataSource readDataSourceOne() {
		log.info("-------------------- read01 DataSourceOne init ---------------------");
		return DataSourceBuilder.create().type(dataSourceType).build();
	}

	/**
	 * 从库2配置
	 * 	
	 * 	（有多少个从库就要配置多少个）
	 * 
	 * @since 2018年6月30日
	 * @auth ynshun
	 * @version 1.0
	 * @return
	 */
	@Bean(name = "readDataSource02")
	@ConfigurationProperties(prefix = "mysql.datasource.read02")
	public DataSource readDataSourceTwo() {
		log.info("-------------------- read02 DataSourceTwo init ---------------------");
		return DataSourceBuilder.create().type(dataSourceType).build();
	}

}