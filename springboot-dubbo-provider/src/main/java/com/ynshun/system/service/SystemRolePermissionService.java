package com.ynshun.system.service;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.ynshun.system.api.ISystemRolePermissionService;

@Component
@Service(interfaceClass = ISystemRolePermissionService.class)
public class SystemRolePermissionService implements ISystemRolePermissionService {

}
