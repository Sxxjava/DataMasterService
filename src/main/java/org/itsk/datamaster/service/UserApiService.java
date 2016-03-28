package org.itsk.datamaster.service;

public interface UserApiService {
	/**
	 * 用户登入
	 * @param phone 用户手机号码
	 * @param password 用户密码
	 * */
	public String login(String phone,String password);
	/**
	 * 用户注册
	 * @param phone 手机号
	 * @param password 密码
	 * @param nickname 昵称
	 * @param thumb 头像
	 * @param smsCode 手机验证码
	 * */
	public String register(String phone,String password,String nickname,String thumb,String smsCode);
	/**
	 * 更新用户信息
	 * @param phone 手机号
	 * @param password 密码
	 * @param nickname 昵称
	 * @param thumb 头像
	 * */
	public String updateUserInfo(String phone,String password,String nickname,String thumb);
	/**
	 * 更新用户密码
	 * @param phone 手机号
	 * @param newPassword 新密码
	 * @param oldPassword 旧密码
	 * */
	public String updateUserPassword(String phone,String newPassword,String oldPassword);
	/**
	 * 找回密码
	 * @param phone 手机号
	 * @param password 新密码
	 * @param smsCode 验证码
	 * */
	public String findPwd(String phone, String password, String smsCode);
	/**
	 * 设置图形密码
	 * @param phone 手机号
	 * @param password 密码
	 * @param photopwd 图形密码
	 * */
	public String setPhotoPwd(String phone, String password, String photopwd);
	/**
	 * 设置数字密码
	 * @param phone 手机号
	 * @param password 密码
	 * @param numberpwd 数字密码
	 * */
	public String setNumberPwd(String phone, String password, String numberpwd);
	/**
	 * 检查用户是否存在
	 * @param phone 手机号
	 * */
	public boolean checkUserExist(String phone);
	
	/**
	 * 检查手机号是否已注册
	 * @param phone 手机号
	 * */
	public String checkPhoneExist(String phone);
}
