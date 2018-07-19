package com.ynshun.system.domain;

import javax.persistence.Table;

import com.ynshun.base.entity.BaseEntity;

@Table(name = "system_permission")
public class SystemPermission extends BaseEntity {
	private static final long serialVersionUID = 5721640816010514413L;
	/**
	 * 权限名称
	 */
	private String name;

	/**
	 * 权限编码
	 */
	private String code;

	/**
	 * 权限描述
	 */
	private String memo;

	/**
	 * 权限请求URL
	 */
	private String url;

	/**
	 * 父级ID
	 */
	private Integer parent_id;

	/**
	 * 是否显示为菜单
	 * 
	 * 0: 不显示 1：显示
	 */
	private Integer is_menu;

	/**
	 * 排序
	 */
	private Integer sort;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	public Integer getIs_menu() {
		return is_menu;
	}

	public void setIs_menu(Integer is_menu) {
		this.is_menu = is_menu;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

}
