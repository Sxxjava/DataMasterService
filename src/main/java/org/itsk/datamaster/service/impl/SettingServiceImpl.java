package org.itsk.datamaster.service.impl;

import org.itsk.datamaster.dao.SettingItemsDao;
import org.itsk.datamaster.entity.GeneralResponse;
import org.itsk.datamaster.entity.SettingItems;
import org.itsk.datamaster.entity.UserInfo;
import org.itsk.datamaster.service.SettingService;
import org.itsk.datamaster.service.UserApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class SettingServiceImpl implements SettingService{
	
	@Autowired
	private SettingItemsDao dao;
	@Autowired
	private UserApiService userService;

	@Override
	public String addSettings(String itemsJson) {
		GeneralResponse<SettingItems> response=new GeneralResponse<SettingItems>();
		SettingItems items=new Gson().fromJson(itemsJson, new TypeToken<SettingItems>(){}.getType());
		int flag=dao.addSettings(items);
		if (flag>0) {
			response.setSuccess(true);
			response.setData(items);
			response.setMsg("设置成功");
		}else{
			response.setMsg("设置失败!");
			response.setData(null);
			response.setSuccess(false);
		}
		return response.toString();
	}

	@Override
	public String updateSettings(String itemsJson) {
		GeneralResponse<SettingItems> response=new GeneralResponse<SettingItems>();
		SettingItems items=new Gson().fromJson(itemsJson, new TypeToken<SettingItems>(){}.getType());
		int flag=dao.updateSettings(items);
		if (flag>0) {
			response.setSuccess(true);
			response.setData(items);
			response.setMsg("设置成功");
		}else{
			response.setMsg("设置失败!");
			response.setData(null);
			response.setSuccess(false);
		}
		return response.toString();
	}

	@Override
	public String getSettings(int userId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String setPhotoPwd(String phone, String password, String photopwd) {
		//检查账号是否存在
		GeneralResponse<UserInfo> response=new Gson().fromJson(userService.login(phone, password), new TypeToken<GeneralResponse<UserInfo>>(){}.getType());
		UserInfo userInfo=response.getData();
		if (userInfo==null) {
			//更新失败,用户不存在
			response.setSuccess(false);
			response.setMsg("设置失败,手机号不存在!");
			response.setData(null);
			return response.toString();
		}
		int flag=-1;
		flag=dao.setPhotoPwd(photopwd,userInfo.getId());
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
		GeneralResponse<UserInfo> response=new Gson().fromJson(userService.login(phone, password), new TypeToken<GeneralResponse<UserInfo>>(){}.getType());
		UserInfo userInfo=response.getData();
		if (userInfo==null) {
			//更新失败,用户不存在
			response.setSuccess(false);
			response.setMsg("设置失败,手机号不存在!");
			response.setData(null);
			return response.toString();
		}
		int flag=-1;
		flag=dao.setNumberPwd(numberpwd,userInfo.getId());
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
}
