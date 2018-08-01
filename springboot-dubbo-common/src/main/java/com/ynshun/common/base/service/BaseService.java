package com.ynshun.common.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ynshun.common.base.mapper.BaseMapper;

public class BaseService<T> implements ServiceInterface<T> {
	@Autowired
	private BaseMapper<T> baseMapper;

	@Override
	public T getOne(Integer id) {
		return baseMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<T> getAll() {
		return baseMapper.selectAll();
	}

	@Override
	public T addOne(T entity) {
		baseMapper.insert(entity);
		return entity;
	}

	@Override
	public T updateOne(T entity) {
		baseMapper.updateByPrimaryKey(entity);
		return entity;
	}

	@Override
	public void deleteOne(T entity) {
		baseMapper.delete(entity);
	}

	@Override
	public void deleteByPrimary(Integer id) {
		baseMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int selectCount(T entity) {
		return baseMapper.selectCount(entity);
	}

	@Override
	public List<T> select(T entity) {
		return baseMapper.select(entity);
	}

}
