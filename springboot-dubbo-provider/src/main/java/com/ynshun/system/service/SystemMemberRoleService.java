package com.ynshun.system.service;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.ynshun.system.api.ISystemMemberRoleService;

@Component
@Service(interfaceClass = ISystemMemberRoleService.class)
public class SystemMemberRoleService implements ISystemMemberRoleService {

}
