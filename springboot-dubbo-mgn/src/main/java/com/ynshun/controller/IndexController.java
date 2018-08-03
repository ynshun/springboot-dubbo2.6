package com.ynshun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ynshun.common.base.controller.BaseController;
import com.ynshun.common.data.MapData;
import com.ynshun.common.util.TypeUtil;

@Controller
public class IndexController extends BaseController {

	/**
	 * 调转页面至首页
	 *
	 *
	 * @return
	 * @since 2018年7月20日
	 * @auth ynshun
	 * @version 1.0
	 */
	@GetMapping(value = { "", "/", "index" })
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("index");
		return view;
	}

	
	@GetMapping("/topage/**")
	public ModelAndView toPage() {
		String fullpath = this.getRequest().getRequestURI();
		String path = fullpath.substring(8);
		
		ModelAndView view = new ModelAndView(path);
		MapData params = this.getParameters();
		for (Object key : params.keySet()) {
			view.addObject(TypeUtil.transfer(key, String.class) , params.get(key));
		}
		return view;
	}

}
