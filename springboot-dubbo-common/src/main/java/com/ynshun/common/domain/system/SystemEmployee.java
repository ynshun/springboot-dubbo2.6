package com.ynshun.common.domain.system;

import javax.persistence.Table;

import com.ynshun.common.base.entity.BaseEntity;

@Table(name = "system_employee")
public class SystemEmployee extends BaseEntity {
	private static final long serialVersionUID = 7407199532516915108L;

	// 员工姓名
	private String name;

	// 登录名
	private String loginname;

	// 登录密码
	private Integer loginpwd;

	// 角色ID
	private Integer role_id;

	// 显示图标
	private String icon_skin;

	// 描述
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public Integer getLoginpwd() {
		return loginpwd;
	}

	public void setLoginpwd(Integer loginpwd) {
		this.loginpwd = loginpwd;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public String getIcon_skin() {
		return icon_skin;
	}

	public void setIcon_skin(String icon_skin) {
		this.icon_skin = icon_skin;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}