package org.itsk.datamaster.dao;

import org.apache.ibatis.annotations.Param;
import org.itsk.datamaster.entity.SettingItems;

public interface SettingItemsDao {
	/**
	 * 添加设置信息
	 * @param items 设置信息对象
	 * */
	public int addSettings(@Param("items")SettingItems items);
	/**
	 * 更新设置信息
	 * @param items 设置信息对象
	 * */
	public int updateSettings(@Param("items")SettingItems items);
	/**
	 * 获取用户的设置信息
	 * */
	public SettingItems getSettings(@Param("userId")int userId);
	/**
	 * 设置图形密码
	 * @param photoPwd 图形密码
	 * */
	public int setNumberPwd(@Param("numberpwd")String photoPwd,@Param("userId")int userId);
	/**
	 * 设置数字密码
	 * @param photoPwd 数字密码
	 * */
	public int setPhotoPwd(@Param("photopwd")String numberPwd,@Param("userId")int userId);
}
