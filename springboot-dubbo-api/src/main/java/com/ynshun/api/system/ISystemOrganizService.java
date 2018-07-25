package com.ynshun.api.system;

import java.util.List;

import com.ynshun.common.base.service.ServiceInterface;
import com.ynshun.common.data.MapData;
import com.ynshun.common.domain.system.SystemOrganiz;

public interface ISystemOrganizService extends ServiceInterface<SystemOrganiz> {

	/**
	 * 根据组织架构ID获取下级组织架构 & 下级用户角色
	 *
	 * @param parentId
	 * @return
	 * @since 2018年7月24日
	 * @auth ynshun
	 * @version 1.0
	 */
	public List<MapData> selectChildrenByRole(Integer parentId);
	
	/**
	 * 根据用户角色ID对用用户
	 *
	 * @param parentId
	 * @return
	 * @since 2018年7月24日
	 * @auth ynshun
	 * @version 1.0
	 */
	public List<MapData> selectChildrenByOrg(Integer parentId);

}
