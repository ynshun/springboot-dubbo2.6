package com.ynshun.system.domain;

import javax.persistence.Table;

import com.ynshun.base.entity.BaseEntity;

@Table(name = "system_role")
public class SystemRole extends BaseEntity {
	private static final long serialVersionUID = 5721640816010514413L;

	/**
	 * 角色名称
	 */
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
