package org.itsk.datamaster.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.itsk.datamaster.entity.UserInfo;

public interface UserApiDao {
	/**
	 * 用户登入
	 * @param phone 用户手机号码
	 * @param password 用户密码
	 * */
	public UserInfo login(@Param("phone")String phone,@Param("password")String password);
	/**
	 * 用户注册
	 * @param user 新用户对象
	 * */
	public int register(@Param("user")UserInfo user);
	/**
	 * 更新用户信息
	 * @param user 新的用户信息对象
	 * */
	public int updateUserInfo(@Param("user")UserInfo user);
	/**
	 * 更新用户密码
	 * @param phone 用户手机号码
	 * @param newPassword 新密码
	 * @param oldPassword 旧密码
	 * */
	public int updateUserPassword(@Param("phone")String phone, @Param("newPassword")String newPassword,@Param("oldPassword")String oldPassword);
	/**
	 * 根据用户名获取记录数
	 * */
	public int getUserCountByUserName(@Param("phone")String phone);
	/**
	 * 获取所有用户
	 * */
	public List<UserInfo> getUsers();
	
	/**
	 * 找回密码
	 * */
	public int findPwd(@Param("phone")String phone, @Param("password")String password);
	/**
	 * 找回密码
	 * */
	public int setPhotoPwd(@Param("phone")String phone, @Param("password")String password,@Param("photopwd")String photopwd);
	/**
	 * 找回密码
	 * */
	public int setNumberPwd(@Param("phone")String phone, @Param("password")String password,@Param("numberpwd")String numberpwd);
}
