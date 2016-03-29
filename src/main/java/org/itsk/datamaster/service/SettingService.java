package org.itsk.datamaster.service;

public interface SettingService {
	/**
	 * 添加设置信息
	 * @param items 设置信息对象
	 * */
	public String addSettings(String itemsJson);
	/**
	 * 更新设置信息
	 * @param items 设置信息对象
	 * */
	public String updateSettings(String itemsJson);
	/**
	 * 获取用户的设置信息
	 * */
	public String getSettings(int userId);
	/**
	 * 设置图形密码
	 * @param numberPwd 数字密码
	 * */
	public String setNumberPwd(String phone,String password,String numberPwd);
	/**
	 * 设置数字密码
	 * @param photoPwd 图形密码
	 * */
	public String setPhotoPwd(String phone,String password,String photopwd);
}
