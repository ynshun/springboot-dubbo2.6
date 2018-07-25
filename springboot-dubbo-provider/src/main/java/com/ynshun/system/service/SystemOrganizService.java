package com.ynshun.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.ynshun.api.system.ISystemOrganizService;
import com.ynshun.common.base.service.BaseService;
import com.ynshun.common.data.MapData;
import com.ynshun.common.domain.system.SystemOrganiz;
import com.ynshun.system.mapper.SystemOrganizMapper;

@Component
@Service(interfaceClass = ISystemOrganizService.class)
public class SystemOrganizService extends BaseService<SystemOrganiz> implements ISystemOrganizService {
	@Autowired
	private SystemOrganizMapper systemOrganizMapper;

	@Override
	public List<MapData> selectChildrenByRole(Integer parentId) {
		return systemOrganizMapper.selectChildrenByRole(parentId);
	}

	@Override
	public List<MapData> selectChildrenByOrg(Integer parentId) {
		return systemOrganizMapper.selectChildrenByOrg(parentId);
	}

}
