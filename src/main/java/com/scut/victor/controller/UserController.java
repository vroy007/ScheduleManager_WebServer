package com.scut.victor.controller;

import com.alibaba.fastjson.JSON;
import com.scut.victor.model.User;
import com.scut.victor.pojo.UserPojo;
import com.scut.victor.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;

	/*
	 * 登录接口
	 */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public String login(User user) {
		User userModel = userService.login(user);
		if (userModel != null) {
            System.out.println(userModel.toString());
			UserPojo userPojo = new UserPojo();
			userPojo.setId(userModel.getId());
			userPojo.setUserId(userModel.getUserId());
			userPojo.setLastTime(userModel.getLastTime());
			String json = JSON.toJSONString(userPojo);
			return json;
		}
		else
			return null;
	}
}
