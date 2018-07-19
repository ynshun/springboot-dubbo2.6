package com.ynshun.common.aop;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

import com.ynshun.common.config.mybatis.DataSourceContextHolder;
import com.ynshun.common.enums.DataSourceType;

@Aspect
@Component
@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
public class DataSourceAopInService implements PriorityOrdered {

	@Before("execution(* com.ynshun.**.service..*.*(..)) "
			+ " and @annotation(com.ynshun.common.annotation.ReadDataSource) ")
	public void setReadDataSourceType() {
		// 如果已经开启写事务了，那之后的所有读都从写库读
		if (!DataSourceType.write.getType().equals(DataSourceContextHolder.getReadOrWrite())) {
			DataSourceContextHolder.setRead();
		}
	}

	@Before("execution(* com.ynshun.**.service..*.*(..)) "
			+ " and @annotation(com.ynshun.common.annotation.WriteDataSource) ")
	public void setWriteDataSourceType() {
		DataSourceContextHolder.setWrite();
	}

	@Override
	public int getOrder() {
		return 1;
	}

}