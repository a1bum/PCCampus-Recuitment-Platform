package com.a1bum.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.a1bum.entity.User;
import com.a1bum.service.UserService;
import com.a1bum.utils.WX;

@RequestMapping("user")
@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@ResponseBody
	@RequestMapping("isExist")
	public Map<String, Object> decrypt(@RequestParam("jscode") String jscode) throws IOException{
		Map<String, Object> map = new HashMap<>();
		String wx_id = WX.decrypt(jscode);
		// 该user存储数据并不规范，目前仅作为一个临时变量做判断用
//		System.out.println(wx_id);
		User user = new User(wx_id, "", userService.isExist(wx_id));
		map.put("user", user);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("add")
	public Map<String, Object> addUser(@RequestParam("wx_id") String wx_id, @RequestParam("user_name") String user_name) {
		User user = new User(wx_id, user_name, "");
		Map<String, Object> map = new HashMap<>();
		map.put("result", userService.addUser(user));
		return map;
	}
	
	@ResponseBody
	@RequestMapping("get")
	public Map<String, Object> getUser(@RequestParam("wx_id")String wx_id){
		Map<String, Object> map = new HashMap<>();
		map.put("result", userService.getUser(wx_id));
		return map;
	}
}
