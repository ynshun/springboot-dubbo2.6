package com.ynshun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ynshun.api.system.ISystemOrganizService;
import com.ynshun.common.base.controller.BaseController;
import com.ynshun.common.data.MapData;
import com.ynshun.common.data.result.DatatableResult;

@Controller
@RequestMapping("/component/")
public class ComponentController extends BaseController {
	@Reference
	private ISystemOrganizService systemOrganizService;

	
	@PostMapping("ajax/organiz/pagelist")
	public @ResponseBody DatatableResult organizPagelist(Integer start, Integer length) {
		MapData params = this.getParameters();
		return systemOrganizService.getNodesByPage(start, length, params);
	}
	
}