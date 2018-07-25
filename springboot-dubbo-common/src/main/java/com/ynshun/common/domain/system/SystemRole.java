package com.ynshun.common.domain.system;

import javax.persistence.Table;

import com.ynshun.common.base.entity.BaseEntity;

@Table(name = "system_role")
public class SystemRole extends BaseEntity {
	private static final long serialVersionUID = 7407199532516915108L;

	// 角色名字
	private String role_name;

	// 角色编码
	private String role_code;

	// 所属部门ID
	private Integer org_id;

	// 显示图标
	private String icon_skin;

	// 描述
	private String description;

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getRole_code() {
		return role_code;
	}

	public void setRole_code(String role_code) {
		this.role_code = role_code;
	}

	public Integer getOrg_id() {
		return org_id;
	}

	public void setOrg_id(Integer org_id) {
		this.org_id = org_id;
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