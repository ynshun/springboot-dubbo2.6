package com.ynshun.common.domain.system;

import javax.persistence.Table;

import com.ynshun.common.base.entity.BaseEntity;

@Table(name = "system_resources")
public class SystemResources extends BaseEntity {
	private static final long serialVersionUID = 7407199532516915108L;

	// 上级ID
	private Integer parent_id;

	// 标题
	private String title;

	// 编码
	private String code;

	// 请求方式 POST | GET | DELETE | UPDATE
	private String method;

	// 请求URL
	private String url;

	// 是否作为菜单显示
	private Integer is_menu;

	// 描述信息
	private String description;

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getIs_menu() {
		return is_menu;
	}

	public void setIs_menu(Integer is_menu) {
		this.is_menu = is_menu;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}