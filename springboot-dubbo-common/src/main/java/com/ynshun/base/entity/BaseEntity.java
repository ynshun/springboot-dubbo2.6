package com.ynshun.base.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import net.sf.json.JSONObject;

public class BaseEntity implements Serializable {
	private static final long serialVersionUID = 6685776322078057653L;

	/**
	 * 主键
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 记录创建时间
	 */
	@Column(name = "create_time")
	private Date create_time;

	/**
	 * 记录创建人ID
	 */
	@Column(name = "create_id")
	private Integer create_id;

	/**
	 * 记录创建人姓名
	 */
	@Column(name = "create_name")
	private String create_name;

	/**
	 * 记录最后一次修改时间
	 */
	@Column(name = "last_update_time")
	private Date last_update_time;

	/**
	 * 记录最后一次修改人ID
	 */
	@Column(name = "last_update_id")
	private Integer last_update_id;

	/**
	 * 记录最后一次修改人姓名
	 */
	@Column(name = "last_update_name")
	private String last_update_name;

	/**
	 * 记录状态
	 * 
	 * 0：未删除 
	 * 1：已删除 
	 */
	@Column(name = "deleted")
	private Integer deleted;

	public String toJson() {
		return JSONObject.fromObject(this).toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Integer getCreate_id() {
		return create_id;
	}

	public void setCreate_id(Integer create_id) {
		this.create_id = create_id;
	}

	public String getCreate_name() {
		return create_name;
	}

	public void setCreate_name(String create_name) {
		this.create_name = create_name;
	}

	public Date getLast_update_time() {
		return last_update_time;
	}

	public void setLast_update_time(Date last_update_time) {
		this.last_update_time = last_update_time;
	}

	public Integer getLast_update_id() {
		return last_update_id;
	}

	public void setLast_update_id(Integer last_update_id) {
		this.last_update_id = last_update_id;
	}

	public String getLast_update_name() {
		return last_update_name;
	}

	public void setLast_update_name(String last_update_name) {
		this.last_update_name = last_update_name;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

}
