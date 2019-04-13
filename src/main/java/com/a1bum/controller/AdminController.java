package com.a1bum.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.a1bum.entity.Admin;
import com.a1bum.service.AdminService;

@RequestMapping("admin")
@Controller
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@RequestMapping("cri_list")
	public String showCRIList() {
		return "cri-list";
	}
	
	@RequestMapping("toWelcome")
	public String toWelcome() {
		return "welcome";
	}
	
	@ResponseBody
	@RequestMapping("login")
	public Map<String, Object> login(String account, String password){
		Map<String, Object> map = new HashMap<>();
		Admin admin = adminService.login(account, password);
		map.put("msg", admin==null?"fail":"success");
		System.out.println(admin);
		return map;
	}
	
	@RequestMapping("toIndex")
	public String toMain() {
		return "index";
	}
}
