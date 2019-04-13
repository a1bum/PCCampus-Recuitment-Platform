package com.a1bum.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.a1bum.entity.CRI;
import com.a1bum.service.CRIService;
import com.github.pagehelper.PageHelper;


@RequestMapping("info")
@Controller
public class CRIController {
	@Autowired
	CRIService criService;
	
	
	@RequestMapping("add")
	public void addCRI(String company_name, String company_official, String hold_date, String start_time, String end_time,String university_name, String locations) {
		CRI cri = new CRI(company_name,company_official,hold_date,start_time,end_time,university_name,locations);
		criService.addCRI(cri);
	}
	
	@ResponseBody
	@RequestMapping("page")
	public Map<String, Object> getAll(@RequestParam(name = "p", defaultValue = "1", required = true) Integer pageNum){
		PageHelper.startPage(pageNum, 10);
		List<CRI> cries = criService.getAll();
		Map<String, Object> map = new HashMap<>();
		map.put("cri", cries);
		System.out.println(map);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("query")
	public Map<String, Object> getByKeyword(@RequestParam(name = "p", defaultValue = "1", required = true) Integer pageNum,@RequestParam("key") String keyword, @RequestParam("today") String today){
		PageHelper.startPage(pageNum, 10);
		Map<String, Object> map = new HashMap<>();
		List<CRI> cries = criService.getByKeyword(keyword, today);
		map.put("cri", cries);
		return map;
		
	}
	
	@ResponseBody
	@RequestMapping("date")
	public Map<String, Object> getBydate(@RequestParam(name = "p", defaultValue = "1", required = true) Integer pageNum, String key) {
		PageHelper.startPage(pageNum, 10);
		Map<String, Object> map = new HashMap<>();
		List<CRI> cries = criService.getByDate(key);
		map.put("cri", cries);
		return map;
	}
}
