package com.ynshun.api.system;

import com.ynshun.common.base.service.ServiceInterface;
import com.ynshun.common.data.MapData;
import com.ynshun.common.data.result.DatatableResult;
import com.ynshun.common.domain.system.SystemEmployee;

public interface ISystemEmployeeService extends ServiceInterface<SystemEmployee> {

	/**
	 * 分页查询员工信息
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

	/**
	 * 根据登录名查询员工信息
	 *
	 * @param loginname
	 * @return
	 * @since 2018年7月31日
	 * @auth ynshun
	 * @version 1.0
	 */
	public SystemEmployee selectByLoginname(String loginname);
}