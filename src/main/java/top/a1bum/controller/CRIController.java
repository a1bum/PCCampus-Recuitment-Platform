package top.a1bum.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
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

	@ResponseBody
	@RequestMapping("statistic")
	public Map<String, Object> getStatistics() {
		Map<String, Object> map = new HashMap<String, Object>();
		// 获得所有数据总数
		int total = criService.getAll().size();
		map.put("total", total);
		// 获得已举行的
		// 获取当前值
		Date curDate = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today = sd.format(curDate.getTime()).split(" ")[0];
		String time = sd.format(curDate.getTime()).split(" ")[1];
		int isHolds = criService.getByCampusAndIsExpired("兰州交通大学", 0, today, time).size();
		map.put("isHolds", isHolds);
		int isNHolds = criService.getByCampusAndIsExpired("兰州交通大学", 1, today, time).size();
		map.put("isNHolds", isNHolds);
		map.put("review", 10);
		return map;
	}

	@ResponseBody
	@RequestMapping("detail")
	public Map<String, Object> getDetail(@RequestParam("id") String id) throws UnsupportedEncodingException {
		Map<String, Object> map = new HashMap<>();
		CRI cri = criService.getById(id);
		byte[] decode_byte = Base64.decodeBase64(cri.getDetail());
		String decode = new String(decode_byte, "utf-8");
		cri.setDetail(decode);
		map.put("cri", cri);
		return map;
	}

	@ResponseBody
	@RequestMapping("modify")
	public Map<String, Object> modify(@RequestParam("id") Integer id, @RequestParam("company_name") String company_name,
			@RequestParam("hold_date") String hold_date, @RequestParam("start_time") String start_time,
			@RequestParam("locations") String locations, @RequestParam("detail") String detail) {
		Map<String, Object> map = new HashMap<>();
		CRI cri = new CRI(id, "0", company_name, "", "", hold_date, start_time, locations, "", "", "", detail);
		Boolean result = criService.modify(cri);
		map.put("msg", result.toString());
		return map;
	}

	@RequestMapping("cri_edit")
	public String edit(@RequestParam("id") String id, Model model) {
		CRI cri = criService.getById(id);
		model.addAttribute("cri", cri);
		return "cri/cri-edit";
	}

	@ResponseBody
	@RequestMapping("delete")
	public Map<String, Object> delelteByIds(@RequestParam("id[]") Integer[] ids) {
		Map<String, Object> map = new HashMap<>();
		System.out.println(Arrays.toString(ids));
		Boolean result = criService.deleteByIds(ids);
		map.put("msg", result.toString());
		return map;
	}

	@RequestMapping("cri_add")
	public String showCRIAdd() {
		return "cri/cri-add";
	}

	@ResponseBody
	@RequestMapping("cri_list_expired")
	public Map<String, Object> returnCRIList(@RequestParam("page") int pageNum, @RequestParam("limit") int pageSize,
			@RequestParam("isExpired") Integer isExpired) {
		Map<String, Object> map = new HashMap<>();
		// 获取当前值
		Date curDate = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today = sd.format(curDate.getTime()).split(" ")[0];
		String time = sd.format(curDate.getTime()).split(" ")[1];
		// 分页
		PageHelper.startPage(pageNum, pageSize);
		List<CRI> cries = criService.getByCampusAndIsExpired("兰州交通大学", isExpired, today, time);
		// 传值
		PageInfo<CRI> pageInfo = new PageInfo<>(cries);
		map.put("code", cries.size() == 0 ? -1 : 0);
		map.put("data", pageInfo);
		return map;
	}

	@RequestMapping("cri_list_limit")
	public String showCRIListLimit(@RequestParam("isExpired") Integer isExpired, Model model) {
		model.addAttribute("isExpired", isExpired);
		return "cri/cri-list";
	}

	@RequestMapping("add")
	public Map<String, Object> addCRI(@RequestParam("company_name") String company_name,
			@RequestParam("hold_date") String hold_date, @RequestParam("start_time") String start_time,
			@RequestParam("locations") String locations, @RequestParam("detail") String details) {
		Map<String, Object> map = new HashMap<>();
		CRI cri = new CRI("0", company_name, hold_date, start_time, locations, details);
		Boolean result = criService.addCRI(cri);
		map.put("msg", result.toString());
		return map;
	}

	@ResponseBody
	@RequestMapping("page")
	public Map<String, Object> getAll(@RequestParam(name = "p", defaultValue = "1", required = true) Integer pageNum) {
		PageHelper.startPage(pageNum, 10);
		List<CRI> cries = criService.getWXAll();
		Map<String, Object> map = new HashMap<>();
		PageInfo<CRI> pageInfo = new PageInfo<>(cries);
		map.put("cri", pageInfo);
		return map;
	}

	@RequestMapping("searchPC")
	public String getByKeywordAndDate(@RequestParam(name = "p", defaultValue = "1", required = true) Integer pageNum,
			String keyword, String date, @RequestParam("admin_university") String admin_university,
			@RequestParam("isExpired") Integer isExpired, Model model) {
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
	public Map<String, Object> getByKeyword(
			@RequestParam(name = "p", defaultValue = "1", required = true) Integer pageNum,
			@RequestParam("key") String keyword, @RequestParam("today") String today) {
		PageHelper.startPage(pageNum, 10);
		Map<String, Object> map = new HashMap<>();
		List<CRI> cries = criService.getByKeyword(keyword, today);
		PageInfo<CRI> pageInfo = new PageInfo<>(cries);
		map.put("cri", pageInfo);
		return map;

	}

	@ResponseBody
	@RequestMapping("date")
	public Map<String, Object> getBydate(@RequestParam(name = "p", defaultValue = "1", required = true) Integer pageNum,
			String key) {
		PageHelper.startPage(pageNum, 10);
		Map<String, Object> map = new HashMap<>();
		List<CRI> cries = criService.getByDate(key);
		PageInfo<CRI> pageInfo = new PageInfo<>(cries);
		map.put("cri", pageInfo);
		return map;
	}

	@ResponseBody
	@RequestMapping("click")
	public Map<String, Object> onClick(@RequestParam("id") String id) {
		Map<String, Object> map = new HashMap<>();
		Integer rows = criService.click(id);
		map.put("rows", rows);
		return map;
	}
}
