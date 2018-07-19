package com.ynshun.system.service;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.ynshun.system.api.ISystemRoleService;

@Component
@Service(interfaceClass = ISystemRoleService.class)
public class SystemRoleService implements ISystemRoleService {

}