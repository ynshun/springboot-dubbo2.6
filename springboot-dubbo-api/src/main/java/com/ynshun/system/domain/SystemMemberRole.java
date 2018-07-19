package com.ynshun.system.domain;

import javax.persistence.Table;

import com.ynshun.base.entity.BaseEntity;

@Table(name = "system_member_role")
public class SystemMemberRole extends BaseEntity {
	private static final long serialVersionUID = 5721640816010514413L;

	/**
	 * 角色ID
	 */
	private Integer role_id;

	/**
	 * 后台用户ID
	 */
	private Integer member_id;

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public Integer getMember_id() {
		return member_id;
	}

	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}

}
