package org.itsk.datamaster.service.impl;

import org.itsk.datamaster.dao.UserApiDao;
import org.itsk.datamaster.entity.GeneralResponse;
import org.itsk.datamaster.entity.UserInfo;
import org.itsk.datamaster.service.UserApiService;
import org.itsk.datamaster.utils.SmsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserApiServiceImpl implements UserApiService {
	@Autowired
	private UserApiDao userApiDao;
	@Override
	public String login(String phone, String password) {
		UserInfo userinfo=userApiDao.login(phone, password);
		GeneralResponse<UserInfo> response=new GeneralResponse<UserInfo>();
		if (userinfo!=null) {
			response.setMsg("登入成功!");
			response.setData(userinfo);
			response.setSuccess(true);
		}else{
			int flag=userApiDao.getUserCountByUserName(phone);
			if (checkUserExist(phone)) {
				response.setMsg("用户名/密码错误!");
			}else{
				response.setMsg("用户名不存在!");
			}
			response.setData(null);
			response.setSuccess(false);
		}
		return response.toString();
	}

	@Override
	public String register(String phone, String password, String nickname, String thumb, String smsCode) {
		//检查账号是否存在
		GeneralResponse<UserInfo> response=new GeneralResponse<UserInfo>();
		if (!checkUserExist(phone)) {
			//注册失败,手机号已注册
			response.setSuccess(false);
			response.setMsg("注册失败,手机号已注册 !");
			response.setData(null);
			return response.toString();
		}
		//账号不存在,开始注册
		System.out.println(phone);
		//验证手机是否有效
		String result=SmsUtils.validateCode(phone, smsCode);
		if (result.contains("467")) {
			response.setSuccess(false);
			response.setMsg("注册失败,验证码请求过于频繁,5分钟内同一个号码最多只能请求三次 !");
			response.setData(null);
			return response.toString();
		}else if (result.contains("468")) {
			response.setSuccess(false);
			response.setMsg("注册失败,验证码错误 !");
			response.setData(null);
			return response.toString();
		}
		//开始注册流程
		int flag=-1;
		UserInfo userinfo=new UserInfo(phone,password);
		if (nickname==null) {
			nickname=phone;
		}else if (nickname.isEmpty()) {
			nickname=phone;
		}
		userinfo.setNickname(nickname);
		if (thumb==null) {
			thumb="http://i3.tietuku.com/88abe69ecb52e022s.jpg";
		}else if (thumb.isEmpty()) {
			thumb="http://i3.tietuku.com/88abe69ecb52e022s.jpg";
		}
		userinfo.setThumb(thumb);
		//开始注册
		try {
			flag=userApiDao.register(userinfo);
			if (flag>0) {
				response.setSuccess(true);
				response.setMsg("注册成功!");
				response.setData(userinfo);
				return response.toString();
			}else{
				response.setSuccess(false);
				response.setMsg("注册失败!");
				response.setData(null);
				return response.toString();
			}

		} catch (Exception e) {
			e.printStackTrace();
			response.setSuccess(false);
			response.setMsg("注册失败,服务器错误!");
			response.setData(null);
			return response.toString();
		}
	}

	@Override
	public String updateUserInfo(String phone, String password, String nickname, String thumb) {
		//检查账号是否存在
		GeneralResponse<UserInfo> response=new GeneralResponse<UserInfo>();
		if (!checkUserExist(phone)) {
			//更新失败,用户不存在
			response.setSuccess(false);
			response.setMsg("更新失败,用户不存在!");
			response.setData(null);
			return response.toString();
		}
		int flag=-1;
		UserInfo userinfo=new UserInfo(phone, password);
		if (nickname==null) {
			nickname=phone;
		}else if (nickname.isEmpty()) {
			nickname=phone;
		}
		userinfo.setNickname(nickname);
		if (thumb==null) {
			thumb="http://i3.tietuku.com/88abe69ecb52e022s.jpg";
		}else if (thumb.isEmpty()) {
			thumb="http://i3.tietuku.com/88abe69ecb52e022s.jpg";
		}
		userinfo.setThumb(thumb);
		flag=userApiDao.updateUserInfo(userinfo);
		if (flag>0) {
			response.setMsg("更新成功!");
			response.setData(userinfo);
			response.setSuccess(true);
		}else{
			response.setMsg("更新失败!");
			response.setData(null);
			response.setSuccess(false);
		}
		return response.toString();
	}

	@Override
	public String updateUserPassword(String phone, String newPassword, String oldPassword) {
		//检查账号是否存在
		GeneralResponse<UserInfo> response=new GeneralResponse<UserInfo>();
		if (!checkUserExist(phone)) {
			//更新失败,用户不存在
			response.setSuccess(false);
			response.setMsg("更新失败,用户不存在!");
			response.setData(null);
			return response.toString();
		}
		int flag=-1;
		flag=userApiDao.updateUserPassword(phone, newPassword, oldPassword);
		if (flag>0) {
			response.setMsg("更新成功!");
			response.setData(userApiDao.login(phone, newPassword));
			response.setSuccess(true);
		}else{
			response.setMsg("更新失败!");
			response.setData(null);
			response.setSuccess(false);
		}
		return response.toString();
	}

	@Override
	public String findPwd(String phone, String password, String smsCode) {
		//检查账号是否存在
		GeneralResponse<UserInfo> response=new GeneralResponse<UserInfo>();
		if (!checkUserExist(phone)) {
			//更新失败,用户不存在
			response.setSuccess(false);
			response.setMsg("找回失败,手机号不存在!");
			response.setData(null);
			return response.toString();
		}
		//验证手机是否有效
		String result=SmsUtils.validateCode(phone, smsCode);
		if (result.contains("467")) {
			response.setSuccess(false);
			response.setMsg("找回失败,验证码请求过于频繁,5分钟内同一个号码最多只能请求三次 !");
			response.setData(null);
			return response.toString();
		}else if (result.contains("468")) {
			response.setSuccess(false);
			response.setMsg("找回失败,验证码错误 !");
			response.setData(null);
			return response.toString();
		}
		int flag=-1;
		flag=userApiDao.findPwd(phone, password);
		if (flag>0) {
			response.setMsg("找回成功!");
			response.setData(userApiDao.login(phone, password));
			response.setSuccess(true);
		}else{
			response.setMsg("找回失败!");
			response.setData(null);
			response.setSuccess(false);
		}
		return response.toString();
	}

	@Override
	public String setPhotoPwd(String phone, String password, String photopwd) {
		//检查账号是否存在
		GeneralResponse<UserInfo> response=new GeneralResponse<UserInfo>();
		if (!checkUserExist(phone)) {
			//更新失败,用户不存在
			response.setSuccess(false);
			response.setMsg("设置失败,手机号不存在!");
			response.setData(null);
			return response.toString();
		}
		int flag=-1;
		flag=userApiDao.setPhotoPwd(phone, password,photopwd);
		if (flag>0) {
			response.setMsg("设置成功!");
			response.setData(null);
			response.setSuccess(true);
		}else{
			response.setMsg("设置失败!");
			response.setData(null);
			response.setSuccess(false);
		}
		return response.toString();
	}

	@Override
	public String setNumberPwd(String phone, String password, String numberpwd) {
		//检查账号是否存在
		GeneralResponse<UserInfo> response=new GeneralResponse<UserInfo>();
		if (!checkUserExist(phone)) {
			//更新失败,用户不存在
			response.setSuccess(false);
			response.setMsg("设置失败,手机号不存在!");
			response.setData(null);
			return response.toString();
		}
		int flag=-1;
		flag=userApiDao.setNumberPwd(phone, password,numberpwd);
		if (flag>0) {
			response.setMsg("设置成功!");
			response.setData(null);
			response.setSuccess(true);
		}else{
			response.setMsg("设置失败!");
			response.setData(null);
			response.setSuccess(false);
		}
		return response.toString();
	}
	@Override
	public boolean checkUserExist(String phone){
		int flag=userApiDao.getUserCountByUserName(phone);
		if (flag<1) {
			//用户不存在
			return false;
		}
		return true;
	}

	@Override
	public String checkPhoneExist(String phone) {
		GeneralResponse<UserInfo> response=new GeneralResponse<UserInfo>();
		if (!checkUserExist(phone)) {
			//用户不存在
			response.setSuccess(true);
			response.setMsg("当前手机可以注册!");
			response.setData(null);
			return response.toString();
		}
		response.setSuccess(false);
		response.setMsg("当前手机已经注册!");
		response.setData(null);
		return response.toString();
	}
}
