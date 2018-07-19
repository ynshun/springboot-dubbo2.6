package com.ynshun.system.service;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.ynshun.system.api.ISystemPermissionService;

@Component
@Service(interfaceClass = ISystemPermissionService.class)
public class SystemPermissionService implements ISystemPermissionService {

}
