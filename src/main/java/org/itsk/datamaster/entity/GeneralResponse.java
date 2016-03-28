package org.itsk.datamaster.entity;

import com.google.gson.Gson;

import java.util.UUID;

/**
 * 
 * @author Jour 网络请求返回的实体类.包含请求成功失败, 请求响应数据等内容 .
 */

public class GeneralResponse<T> {

	public String toString() {
		return new Gson().toJson(this);
	}

	private String msg;
	private boolean success = true;
	private String token = null;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String randomToken() {
		this.token = UUID.randomUUID().toString();
		return this.token;
	}

	private long timestamp = System.currentTimeMillis();
	private T data;

	public GeneralResponse() {

	}

	public GeneralResponse(boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}