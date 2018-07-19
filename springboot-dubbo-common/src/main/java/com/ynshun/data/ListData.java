package com.ynshun.data;

import java.util.ArrayList;
import java.util.List;

import com.ynshun.util.TypeUtil;

public class ListData extends ArrayList<Object> implements List<Object> {
	private static final long serialVersionUID = 551034812632720938L;


	public static ListData getInstance() {
		return new ListData();
	}
	
	public ListData addData(Object data) {
		super.add(data);
		return this;
	}
	
	public String getString(int index) {
		return this.get(index, String.class);
	}
	
	public Integer getInt(int index) {
		return this.get(index, Integer.class, null);
	}
	
	public Double getDouble(int index) {
		return this.get(index, Double.class, null);
	}
	
	public Long getLong(int index) {
		return this.get(index, Long.class, null);
	}
	
	public <T> T get(int index, Class<T> type) {
		return this.get(index, type, null);
	}
	
	
	public <T> T get(int index, Class<T> type, T defaultData) {
		Object data = this.get(index);
		if (data == null) {
			return defaultData == null ? null : defaultData;
		}
		return TypeUtil.transfer(data, type);
	}
	
}
