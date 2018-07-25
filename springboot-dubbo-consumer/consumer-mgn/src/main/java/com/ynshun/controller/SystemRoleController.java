package com.ynshun.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ynshun.api.system.ISystemOrganizService;
import com.ynshun.common.base.controller.BaseController;
import com.ynshun.common.util.TypeUtil;

@Controller
@RequestMapping("/system/role/")
public class SystemRoleController extends BaseController {
	@Reference
	private ISystemOrganizService systemOrganizService;

	/**
	 * 调转页面至组织架构管理页
	 *
	 * @return
	 * @since 2018年7月20日
	 * @auth ynshun
	 * @version 1.0
	 */
	@GetMapping("list")
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("system/organiz/list");

		return view;
	}
	
	
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
	@PostMapping("/children")
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
}
