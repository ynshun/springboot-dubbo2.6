package com.ynshun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

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

	/**
	 * 调转页面至控制面板页
	 *
	 * @return
	 * @since 2018年7月20日
	 * @auth ynshun
	 * @version 1.0
	 */
	@GetMapping(value = "main")
	public ModelAndView main() {
		ModelAndView view = new ModelAndView("main");

		return view;
	}
}
