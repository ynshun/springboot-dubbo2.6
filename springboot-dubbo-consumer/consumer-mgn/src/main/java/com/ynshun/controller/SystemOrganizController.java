package com.ynshun.controller;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ynshun.api.system.ISystemOrganizService;
import com.ynshun.api.system.ISystemRoleService;
import com.ynshun.common.base.controller.BaseController;
import com.ynshun.common.data.MapData;
import com.ynshun.common.data.result.ApiResult;
import com.ynshun.common.data.result.DatatableResult;
import com.ynshun.common.domain.system.SystemEmployee;
import com.ynshun.common.domain.system.SystemOrganiz;
import com.ynshun.common.domain.system.SystemRole;
import com.ynshun.common.util.TypeUtil;
import com.ynshun.config.MemoryCache;

@Controller
@RequestMapping("/system/organiz/")
public class SystemOrganizController extends BaseController {
	@Reference
	private ISystemOrganizService systemOrganizService;
	@Reference
	private ISystemRoleService systemRoleService;

	/**
	 * 获取子节点
	 *
	 * @param id
	 * @param name
	 * @param level
	 * @return
	 * @since 2018年7月23日
	 * @auth ynshun
	 * @version 1.0
	 */
	@PostMapping("ajax/children")
	public @ResponseBody Object getNodes(String id, String name, String level) {
		Integer parentId = null;
		String type = "org";
		
		if (StringUtils.isNotBlank(id)) {
			String[] temp = id.split("_");
			type = temp[0];
			parentId = TypeUtil.transfer(temp[1], Integer.class);
		}
		
		if ("org".equals(type)) {
			return systemOrganizService.selectChildrenByOrg(parentId);
		} else {
			return systemOrganizService.selectChildrenByRole(parentId);
		}
	}
	
	/**
	 * 分页查询下级组织架构
	 *
	 * @param start
	 * @param length
	 * @return
	 * @since 2018年7月26日
	 * @auth ynshun
	 * @version 1.0
	 */
	@PostMapping("ajax/children/page")
	public @ResponseBody DatatableResult getNodesByPage(Integer start, Integer length) {
		MapData params = this.getParameters();
		if (params.containsKey("id")) {
			params.put("parent_id", params.get("id"));
		}
		return systemOrganizService.getNodesByPage(start, length, params);
	}
	
	
	/**
	 * 根据组织架构ID查询详情
	 *
	 * @param id
	 * @return
	 * @since 2018年7月27日
	 * @auth ynshun
	 * @version 1.0
	 */
	@PostMapping("ajax/detail/{id}")
	public @ResponseBody ApiResult organizDetail(@PathVariable("id") Integer id) {
		SystemOrganiz organiz = systemOrganizService.getOne(id);
		if (organiz == null) {
			return ApiResult.failure("不存在的组织架构信息");
		}
		return ApiResult.success(organiz);
	}
	
	
	/**
	 * 保存组织架构信息[新增|修改]
	 *
	 * @param systemOrganiz
	 * @return
	 * @since 2018年7月27日
	 * @auth ynshun
	 * @version 1.0
	 */
	@PostMapping("ajax/save")
	public @ResponseBody ApiResult saveOrg(SystemOrganiz systemOrganiz) {
		if (StringUtils.isBlank(systemOrganiz.getOrg_name())) {
			return ApiResult.failure("组织架构名称不能为空");
		}
		
		SystemOrganiz query = new SystemOrganiz();
		query.setDeleted(0);
		query.setParent_id(systemOrganiz.getParent_id());
		query.setOrg_name(systemOrganiz.getOrg_name());
		List<SystemOrganiz> oldDatas = systemOrganizService.select(query);
		
		if (oldDatas != null && oldDatas.size() > 1) {
			return ApiResult.failure("对应组织结构下已经存在[" + systemOrganiz.getOrg_name() + "]");
		}
		
		if (oldDatas != null && oldDatas.size() > 0 && systemOrganiz.getId() == null) {
			return ApiResult.failure("对应组织结构下已经存在[" + systemOrganiz.getOrg_name() + "]");
		}
		
		if (oldDatas != null && oldDatas.size() > 0 && systemOrganiz.getId() != null) {
			SystemOrganiz oldData = oldDatas.get(0);
			if (oldData.getId().intValue() != systemOrganiz.getId().intValue()) {
				return ApiResult.failure("对应组织结构下已经存在[" + systemOrganiz.getOrg_name() + "]");
			}
		}
		
		SystemEmployee currentEmployee = MemoryCache.currentEmployee();
		
		if (systemOrganiz.getId() == null) {
			systemOrganiz.setDeleted(0);
			systemOrganiz.setCreate_id(currentEmployee.getId());
			systemOrganiz.setCreate_name(currentEmployee.getName());
			systemOrganiz.setCreate_time(new Date());
			
			systemOrganizService.addOne(systemOrganiz);
		} else {
			systemOrganiz.setDeleted(0);
			systemOrganiz.setLast_update_id(currentEmployee.getId());
			systemOrganiz.setLast_update_name(currentEmployee.getName());
			systemOrganiz.setLast_update_time(new Date());
			
			systemOrganizService.updateOne(systemOrganiz);
		}
		return ApiResult.success();
	}
	
	
	/**
	 * 组织架构信息
	 *
	 * @param id
	 * @return
	 * @since 2018年7月27日
	 * @auth ynshun
	 * @version 1.0
	 */
	@PostMapping("ajax/delete/{id}")
	public @ResponseBody ApiResult saveOrg(@PathVariable("id") Integer id) {
		SystemOrganiz query = new SystemOrganiz();
		query.setDeleted(0);
		query.setParent_id(id);
		int count = systemOrganizService.selectCount(query);
		if (count > 0) {
			return ApiResult.failure("对应组织结构存在下级组织，不能删除！");
		}
		
		SystemRole roleQuery = new SystemRole();
		roleQuery.setDeleted(0);
		roleQuery.setOrg_id(id);
		int roleCount = systemRoleService.selectCount(roleQuery);
		if (roleCount > 0) {
			return ApiResult.failure("对应组织结构存在用户角色，不能删除！");
		}
		
		SystemOrganiz systemOrganiz = systemOrganizService.getOne(id);
		if (systemOrganiz != null) {
			SystemEmployee currentEmployee = MemoryCache.currentEmployee();
			
			systemOrganiz.setDeleted(1);
			systemOrganiz.setLast_update_id(currentEmployee.getId());
			systemOrganiz.setLast_update_name(currentEmployee.getName());
			systemOrganiz.setLast_update_time(new Date());
			systemOrganizService.updateOne(systemOrganiz);
		}
		
		return ApiResult.success();
	}
}
