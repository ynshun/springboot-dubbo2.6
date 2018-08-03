package com.ynshun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ynshun.api.system.ISystemRoleService;
import com.ynshun.common.base.controller.BaseController;
import com.ynshun.common.data.result.DatatableResult;

@Controller
@RequestMapping("/system/role/")
public class SystemRoleController extends BaseController {
	@Reference
	private ISystemRoleService systemRoleService;

	
	/**
	 * 分页查询数据
	 *
	 * @return
	 * @since 2018年7月30日
	 * @auth ynshun
	 * @version 1.0
	 */
	@PostMapping("ajax/query")
	public @ResponseBody DatatableResult query(Integer start, Integer length) {
		return systemRoleService.query(start, length, this.getParameters());
	}
}
