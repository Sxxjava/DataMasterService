package org.itsk.datamaster.api;

import org.itsk.datamaster.service.UserApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/api/user",produces="text/html;charset=utf-8")
public class UserApi {
	@Autowired
	private UserApiService service;
	
	@ResponseBody
	@RequestMapping(value="login")
	public String login(@RequestParam(value = "phone", required = true)String phone,
			@RequestParam(value = "password", required = true)String password){
		return service.login(phone, password);
	}
	@ResponseBody
	@RequestMapping(value="register")
	public String register(@RequestParam(value = "phone", required = true)String phone,
			@RequestParam(value = "password", required = true)String password,
			@RequestParam(value = "nickname", required = true)String nickname,
			@RequestParam(value="thumb",required=false)String thumb,
			@RequestParam(value="smsCode",required=true)String smsCode){
		return service.register(phone, password, nickname, thumb, smsCode);
	}
	@ResponseBody
	@RequestMapping(value="updateUserInfo")
	public String updateUserInfo(@RequestParam(value = "phone", required = true)String phone,
			@RequestParam(value = "password", required = true)String password,
			@RequestParam(value = "nickname", required = true)String nickname,
			@RequestParam(value="thumb",required=false)String thumb){
		return service.updateUserInfo(phone, password, nickname, thumb);
	}
	
	@ResponseBody
	@RequestMapping(value="updateUserPassword")
	public String updateUserPassword(@RequestParam(value = "phone", required = true)String phone,
			@RequestParam(value = "newPassword", required = true)String newPassword,
			@RequestParam(value = "oldPassword", required = true)String oldPassword){
		return service.updateUserPassword(phone, newPassword, oldPassword);
	}
	
	@ResponseBody
	@RequestMapping(value="findpwd")
	public String findPwd(@RequestParam(value = "phone", required = true)String phone,
			@RequestParam(value = "password", required = true)String password,
			@RequestParam(value = "smsCode", required = true)String smsCode){
		return service.findPwd(phone, password,smsCode);
	}
	
	@ResponseBody
	@RequestMapping(value="setPhotopwd")
	public String setPhotoPwd(@RequestParam(value = "phone", required = true)String phone,
			@RequestParam(value = "password", required = true)String password,
			@RequestParam(value = "photopwd", required = true)String photopwd){
		return service.setPhotoPwd(phone, password, photopwd);
	}
	
	@ResponseBody
	@RequestMapping(value="setNumberpwd")
	public String setNumberPwd(@RequestParam(value = "phone", required = true)String phone,
			@RequestParam(value = "password", required = true)String password,
			@RequestParam(value = "numberpwd", required = true)String numberpwd){
		return service.setNumberPwd(phone, password, numberpwd);
	}
	
	@ResponseBody
	@RequestMapping(value="checkPhoneExist")
	public String checkPhoneExist(@RequestParam(value = "phone", required = true)String phone){
		return service.checkPhoneExist(phone);
	}
}
