package com.ynshun.api.system;

import com.ynshun.common.base.service.ServiceInterface;
import com.ynshun.common.data.MapData;
import com.ynshun.common.data.result.DatatableResult;
import com.ynshun.common.domain.system.SystemRole;

public interface ISystemRoleService extends ServiceInterface<SystemRole> {

	/**
	 * 分页查询用户角色
	 *
	 * @param start
	 * @param pagesize
	 * @param params
	 * @return
	 * @since 2018年7月30日
	 * @auth ynshun
	 * @version 1.0
	 */
	public DatatableResult query(Integer start, Integer pagesize, MapData params);
}