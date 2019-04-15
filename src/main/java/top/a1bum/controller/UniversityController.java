package top.a1bum.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import top.a1bum.entity.University;
import top.a1bum.service.UniversityService;

@RequestMapping("university")
@Controller
public class UniversityController {
	@Autowired
	UniversityService universityService;
	
	@ResponseBody
	@RequestMapping("isExist")
	public Map<String, Object> isExist(@RequestParam("university_name")String university_name){
		Map<String, Object> map = new HashMap<>();
		map.put("result", universityService.isExist(university_name));
		return map;
	}
	
	@ResponseBody
	@RequestMapping("getAll")
	public Map<String, Object> getAll(){
		Map<String, Object> map = new HashMap<>();
		List<University> universities = universityService.getAll();
		map.put("univesity", universities);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("query")
	public Map<String, Object> getByKeyword(@RequestParam("keyword")String keyword){
		Map<String, Object> map = new HashMap<>();
		if(!keyword.equals("")) {
			List<University> universities = universityService.getByKeyword(keyword);
			map.put("university", universities);
		}else {
			map.put("msg", "关键字不能为空");
		}
		return map;
	}
}
