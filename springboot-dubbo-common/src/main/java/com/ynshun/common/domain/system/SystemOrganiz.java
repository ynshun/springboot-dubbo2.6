package com.ynshun.common.domain.system;

import javax.persistence.Table;

import com.ynshun.common.base.entity.BaseEntity;

@Table(name = "system_organiz")
public class SystemOrganiz extends BaseEntity {
	private static final long serialVersionUID = 7407199532516915108L;

	// 组织架构名称
	private String org_name;

	// 商家组织架构ID
	private Integer parent_id;

	// 显示图标
	private String icon_skin;

	// 描述信息
	private String description;

	public String getOrg_name() {
		return org_name;
	}

	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
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