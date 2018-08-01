package com.ynshun.system.mapper;

import java.util.List;

import com.ynshun.common.base.mapper.BaseMapper;
import com.ynshun.common.data.MapData;
import com.ynshun.common.domain.system.SystemEmployee;

public interface SystemEmployeeMapper extends BaseMapper<SystemEmployee> {

	public List<MapData> query(MapData params);
}
