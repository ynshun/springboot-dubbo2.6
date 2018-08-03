package com.ynshun.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ynshun.common.data.result.ApiResult;

@Controller
public class LoginController {

	/**
	 * 进入用户登录页面
	 *
	 * @return
	 * @since 2018年8月2日
	 * @auth ynshun
	 * @version 1.0
	 */
	@GetMapping(value = { "login", "signin" })
	public String index() {
		return "signin";
	}

	/**
	 * 登录方法
	 * 
	 * @param userInfo
	 * @return
	 */
	@PostMapping(value = "/ajax/doLogin")
	public @ResponseBody ApiResult ajaxLogin(String username, String password) {
		if (StringUtils.isAnyBlank(username, password)) {
			return ApiResult.failure("用户名或密码不能为空！");
		}
		
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try {
			subject.login(token);
			return ApiResult.success("登录成功！", subject.getSession().getId());
		} catch (IncorrectCredentialsException e) {
			return ApiResult.failure("用户名或密码错误！");
		} catch (LockedAccountException e) {
			return ApiResult.failure("登录失败，该用户已被冻结！");
		} catch (AuthenticationException e) {
			return ApiResult.failure("该用户不存在！");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ApiResult.failure("系统繁忙，请稍后再试！");
	}

	/**
	 * 用户注销
	 *
	 * @return
	 * @since 2018年8月2日
	 * @auth ynshun
	 * @version 1.0
	 */
	@GetMapping(value = { "logout", "signout" })
	public String logOut() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/login.html";
	}

}
