package com.ynshun.system.domain;

import javax.persistence.Table;

import com.ynshun.base.entity.BaseEntity;

@Table(name = "system_role_permission")
public class SystemRolePermission extends BaseEntity {
	private static final long serialVersionUID = 5721640816010514413L;

	/**
	 * 角色ID
	 */
	private Integer role_id;

	/**
	 * 权限ID
	 */
	private Integer permission_id;

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public Integer getPermission_id() {
		return permission_id;
	}

	public void setPermission_id(Integer permission_id) {
		this.permission_id = permission_id;
	}

}
