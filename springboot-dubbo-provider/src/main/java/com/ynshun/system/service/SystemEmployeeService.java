package com.ynshun.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.ynshun.api.system.ISystemEmployeeService;
import com.ynshun.common.base.service.BaseService;
import com.ynshun.common.data.MapData;
import com.ynshun.common.data.result.DatatableResult;
import com.ynshun.common.domain.system.SystemEmployee;
import com.ynshun.config.mybatis.PageHelper;
import com.ynshun.system.mapper.SystemEmployeeMapper;

@Component
@Service(interfaceClass = ISystemEmployeeService.class)
public class SystemEmployeeService extends BaseService<SystemEmployee> implements ISystemEmployeeService {
	@Autowired
	private SystemEmployeeMapper systemEmployeeMapper;

	@Override
	public DatatableResult query(Integer start, Integer pagesize, MapData params) {
		PageHelper.page(start, pagesize);
		List<MapData> datas = systemEmployeeMapper.query(params);
		return PageHelper.buildResult(new PageInfo<>(datas));
	}

	@Override
	public SystemEmployee selectByLoginname(String loginname) {
		SystemEmployee employee = new SystemEmployee();
		employee.setDeleted(0);
		employee.setLoginname(loginname);
		return systemEmployeeMapper.selectOne(employee);
	}

}
