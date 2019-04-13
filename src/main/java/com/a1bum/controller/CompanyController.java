package com.a1bum.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.a1bum.service.CompanyService;

@RequestMapping("company")
@Controller
public class CompanyController {
	@Autowired
	CompanyService companyService;
	
	@ResponseBody
	@RequestMapping("isExist")
	public Map<String, Object> isExist(@RequestParam("company_name")String company_name){
		Map<String,Object> map = new HashMap<>();
		map.put("result", companyService.isExist(company_name));
		System.out.println(companyService.isExist(company_name));
		return map;
	}
}
