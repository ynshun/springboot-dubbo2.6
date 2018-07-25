package com.ynshun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@GetMapping(value = { "login", "signin" })
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("signin");

		return view;
	}
}
