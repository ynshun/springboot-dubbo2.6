package com.ynshun.common.base.service;

import java.util.List;

public interface ServiceInterface<T> {

	/**
	 * 根据主键ID查询数据详情
	 *
	 * @param id
	 * @return
	 * @since 2018年7月20日
	 * @auth ynshun
	 * @version 1.0
	 */
	public T getOne(Integer id);


	/**
	 * 获取所有数据信息
	 *
	 * @return
	 * @since 2018年7月20日
	 * @auth ynshun
	 * @version 1.0
	 */
	public List<T> getAll();

	/**
	 * 新增数据信息
	 *
	 * @param entity
	 * @return
	 * @since 2018年7月20日
	 * @auth ynshun
	 * @version 1.0
	 */
	public T addOne(T entity);

	/**
	 * 修改数据信息
	 *
	 * @param entity
	 * @return
	 * @since 2018年7月20日
	 * @auth ynshun
	 * @version 1.0
	 */
	public T updateOne(T entity);

	/**
	 * 删除数据信息
	 *
	 * @param organiz
	 * @return
	 * @since 2018年7月20日
	 * @auth ynshun
	 * @version 1.0
	 */
	public void deleteOne(T entity);

	/**
	 * 删除数据信息
	 *
	 * @param orgId
	 * @since 2018年7月20日
	 * @auth ynshun
	 * @version 1.0
	 */
	public void deleteByPrimary(Integer id);
}
