package com.ynshun.system.domain;

import java.util.Date;

import javax.persistence.Table;

import com.ynshun.base.entity.BaseEntity;

@Table(name = "system_member")
public class SystemMember extends BaseEntity {
	private static final long serialVersionUID = 7197735778295266415L;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 真实姓名
	 */
	private String name;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 最后登录时间
	 */
	private Date last_login;

	/**
	 * 登出时间
	 */
	private Date out_login_time;

	/**
	 * 登录ip
	 */
	private String login_ip;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLast_login() {
		return last_login;
	}

	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}

	public Date getOut_login_time() {
		return out_login_time;
	}

	public void setOut_login_time(Date out_login_time) {
		this.out_login_time = out_login_time;
	}

	public String getLogin_ip() {
		return login_ip;
	}

	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}

}
