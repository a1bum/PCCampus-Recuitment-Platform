package top.a1bum.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.a1bum.entity.CRI;
import top.a1bum.service.CRIService;


@RequestMapping("info")
@Controller
public class CRIController {
	@Autowired
	CRIService criService;
	
	@RequestMapping("cri_add")
	public String showCRIAdd() {
		return "cri/cri-add";
	}
	
	@RequestMapping("cri_list_limit")
	public String showCRIListLimit(@RequestParam(name = "p", defaultValue = "1") Integer pageNum,
			@RequestParam("admin_university")String admin_university,
			@RequestParam("isExpired")Integer isExpired, Model model) {
		PageHelper.startPage(pageNum, 15);
		// 获取当前时间
		Date curDate = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today = sd.format(curDate.getTime()).split(" ")[0];
		String time = sd.format(curDate.getTime()).split(" ")[1];
		List<CRI> cries = criService.getByCampusAndIsExpired(admin_university, isExpired, today, time);
		// 分页
		PageInfo<CRI> pageInfo = new PageInfo<>(cries);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("isExpired", isExpired);
		model.addAttribute("adminUniversity", admin_university);
		return "cri/cri-list";
	}
	
	@RequestMapping("add")
	public void addCRI(String company_name, String company_official, String hold_date, String start_time, String end_time,String university_name, String locations) {
////		CRI cri = new CRI(company_name,company_official,hold_date,start_time,end_time,university_name,locations);
//		criService.addCRI(cri);
	}
	
	@ResponseBody
	@RequestMapping("page")
	public Map<String, Object> getAll(@RequestParam(name = "p", defaultValue = "1", required = true) Integer pageNum){
		PageHelper.startPage(pageNum, 10);
		List<CRI> cries = criService.getAll();
		Map<String, Object> map = new HashMap<>();
		map.put("cri", cries);
		return map;
	}
	
	@RequestMapping("searchPC")
	public String getByKeywordAndDate(@RequestParam(name = "p", defaultValue = "1", required = true) Integer pageNum,
			String keyword, String date,@RequestParam("admin_university")String admin_university,
			@RequestParam("isExpired")Integer isExpired, Model model) {
		PageHelper.startPage(pageNum, 10);
		List<CRI> cries = criService.getByKeyword(keyword, date);
		PageInfo<CRI> pageInfo = new PageInfo<>(cries);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("isExpired", isExpired);
		model.addAttribute("adminUniversity", admin_university);
		return "cri-list";
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
