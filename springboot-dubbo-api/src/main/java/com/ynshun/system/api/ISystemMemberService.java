package com.ynshun.system.api;

import java.util.List;

import com.ynshun.system.domain.SystemMember;

public interface ISystemMemberService {

	/**
	 * 新增后台管理用户
	 *
	 * @param systemMember
	 * @return
	 * @since 2018年7月18日
	 * @auth ynshun
	 * @version 1.0
	 */
	public SystemMember insertSystemMember(SystemMember systemMember);

	/**
	 * 查询后台管理员用户了列表
	 *
	 * @param systemMember
	 * @return
	 * @since 2018年7月18日
	 * @auth ynshun
	 * @version 1.0
	 */
	public List<SystemMember> selectSystemMember(SystemMember systemMember);
}
