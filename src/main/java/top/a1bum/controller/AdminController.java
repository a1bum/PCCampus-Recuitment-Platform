package top.a1bum.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import top.a1bum.entity.Admin;
import top.a1bum.service.AdminService;

@RequestMapping("admin")
@Controller
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@RequestMapping("admin_info")
	public String showAdminInfo() {
		return "admin/admin-info";
	}
	
	@RequestMapping("admin_list")
	public String showAdminList() {
		return "admin/admin-list";
	}

	@RequestMapping("toWelcome")
	public String toWelcome(Model model) {
		Admin admin = adminService.login("root", "toor");
		// 获取用户信息
		String admin_univeristy = admin.getAdmin_univeristy();
		// 放入model
		model.addAttribute("adminAccount", admin.getAdmin_account());
		model.addAttribute("adminTotals", adminService.getColleagues(admin_univeristy));
		model.addAttribute("adminUniversity", admin_univeristy);
		return "welcome";
	}

	@ResponseBody
	@RequestMapping("login")
	public Map<String, Object> login(@RequestParam("account")String account, @RequestParam("password")String password) {
		Map<String, Object> map = new HashMap<>();
		Admin admin = adminService.login(account, password);
		map.put("msg", admin!=null?"success":"fail");
		return map;
	}

	@RequestMapping("toIndex")
	public String toIndex(Model model) {
		Admin admin = adminService.login("root", "toor");
		model.addAttribute("adminUniversity", admin.getAdmin_univeristy());
		model.addAttribute("adminAccount", admin.getAdmin_account());
		return "index";
	}
}
