package com.ynshun.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.ynshun.common.annotation.ReadDataSource;
import com.ynshun.system.api.ISystemMemberService;
import com.ynshun.system.domain.SystemMember;
import com.ynshun.system.mapper.SystemMemberMapper;


@Component
@Service(interfaceClass = ISystemMemberService.class)
public class SystemMemberService implements ISystemMemberService {
	@Autowired
	private SystemMemberMapper systemMemberMapper;

	@Override
	@Transactional
	public SystemMember insertSystemMember(SystemMember systemMember) {
		systemMemberMapper.insert(systemMember);
		return systemMember;
	}

	@Override
	@ReadDataSource
	public List<SystemMember> selectSystemMember(SystemMember systemMember) {
		return systemMemberMapper.select(systemMember);
	}

}
