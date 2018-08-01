package com.ynshun.common.data.result;

import java.io.Serializable;

public class ApiResult implements Serializable {
	private static final long serialVersionUID = 4277328710305750094L;
	// 接口访问编码（业务逻辑状态）
	private String result_code;
	// 接口访问结果消息
	private String result_message;
	// 返回结果数据
	private Object result_data;

	public static ApiResult instance() {
		return new ApiResult();
	}

	public static ApiResult success() {
		return ApiResult.instance().setResult_code("200").setResult_message("操作成功！");
	}
	
	public static ApiResult success(String message) {
		return ApiResult.success().setResult_message(message);
	}

	public static ApiResult success(Object data) {
		return ApiResult.success().setResult_data(data);
	}

	public static ApiResult success(String message, Object data) {
		return ApiResult.success(message).setResult_data(data);
	}

	public static ApiResult failure() {
		return ApiResult.instance().setResult_code("500").setResult_message("操作失败，请稍后再试！");
	}
	
	public static ApiResult failure(String message) {
		return ApiResult.failure().setResult_message(message);
	}

	public static ApiResult failure(Object data) {
		return ApiResult.failure().setResult_data(data);
	}

	public static ApiResult failure(String message, Object data) {
		return ApiResult.failure(message).setResult_data(data);
	}

	public static ApiResult failure(String code, String message) {
		return ApiResult.failure(message).setResult_code(code);
	}

	public static ApiResult failure(String code, String message, Object data) {
		return ApiResult.failure(code, message).setResult_data(data);
	}

	public ApiResult(String result_code, String result_message, Object result_data) {
		this.result_code = result_code;
		this.result_message = result_message;
		this.result_data = result_data;
	}

	public ApiResult() {

	}

	public String getResult_code() {
		return result_code;
	}

	public ApiResult setResult_code(String result_code) {
		this.result_code = result_code;
		return this;
	}

	public String getResult_message() {
		return result_message;
	}

	public ApiResult setResult_message(String result_message) {
		this.result_message = result_message;
		return this;
	}

	public Object getResult_data() {
		return result_data;
	}

	public ApiResult setResult_data(Object result_data) {
		this.result_data = result_data;
		return this;
	}

}
