package com.ynshun.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ynshun.common.base.mapper.BaseMapper;
import com.ynshun.common.data.MapData;
import com.ynshun.common.domain.system.SystemOrganiz;

public interface SystemOrganizMapper extends BaseMapper<SystemOrganiz> {

	/**
	 * 根据组织架构ID获取下级组织架构 & 下级用户角色
	 *
	 * @param parentId
	 * @return
	 * @since 2018年7月24日
	 * @auth ynshun
	 * @version 1.0
	 */
	public List<MapData> selectChildrenByRole(@Param("parentId") Integer parentId);
	
	/**
	 * 根据用户角色ID对用用户
	 *
	 * @param parentId
	 * @return
	 * @since 2018年7月24日
	 * @auth ynshun
	 * @version 1.0
	 */
	public List<MapData> selectChildrenByOrg(@Param("parentId") Integer parentId);
	
}