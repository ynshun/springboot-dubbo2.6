package com.ynshun.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ynshun.system.api.ISystemMemberService;
import com.ynshun.system.domain.SystemMember;

@RestController
public class HelloController {

	@Reference
	private ISystemMemberService systemMemberService;

	@RequestMapping("/hello")
	public Object hello() {
		try {
			SystemMember member = new SystemMember();
			member.setUsername(UUID.randomUUID().toString());
			member.setName(UUID.randomUUID().toString());
			member.setPassword(UUID.randomUUID().toString());

			member = systemMemberService.insertSystemMember(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return systemMemberService.selectSystemMember(null);
	}

}
