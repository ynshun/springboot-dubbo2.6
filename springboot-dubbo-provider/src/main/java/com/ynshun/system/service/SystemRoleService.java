package com.ynshun.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.ynshun.api.system.ISystemRoleService;
import com.ynshun.common.base.service.BaseService;
import com.ynshun.common.data.MapData;
import com.ynshun.common.data.result.DatatableResult;
import com.ynshun.common.domain.system.SystemRole;
import com.ynshun.config.mybatis.PageHelper;
import com.ynshun.system.mapper.SystemRoleMapper;

@Component
@Service(interfaceClass = ISystemRoleService.class)
public class SystemRoleService extends BaseService<SystemRole> implements ISystemRoleService {
	@Autowired
	private SystemRoleMapper systemRoleMapper;

	@Override
	public DatatableResult query(Integer start, Integer pagesize, MapData params) {
		PageHelper.page(start, pagesize);
		List<MapData> datas = systemRoleMapper.query(params);
		return PageHelper.buildResult(new PageInfo<>(datas));
	}

}
