package com.ynshun.system.mapper;

import java.util.List;

import com.ynshun.common.base.mapper.BaseMapper;
import com.ynshun.common.data.MapData;
import com.ynshun.common.domain.system.SystemRole;

public interface SystemRoleMapper extends BaseMapper<SystemRole> {

	public List<MapData> query(MapData params);
}
