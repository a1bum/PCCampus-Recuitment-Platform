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
import top.a1bum.utils.VersionInformation;

@RequestMapping("admin")
@Controller
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@RequestMapping("admin_add")
	public String showAdminAdd() {
		return "admin/admin-add";
	}
	
	@RequestMapping("admin_info")
	public String showAdminInfo() {
		return "admin/admin-info";
	}
	
	@RequestMapping("admin_list")
	public String showAdminList() {
		return "admin/admin-list";
	}
	
	@ResponseBody
	@RequestMapping("sysinfo")
	public Map<String, Object> getSysInfo(){
		Map<String, Object> map = new HashMap<>();
		VersionInformation ver = new VersionInformation();
		String cpuInfo = ver.getCpuInfo();
		String memInfo = ver.getMemInfo();
		map.put("cpuInfo", cpuInfo);
		map.put("memInfo", memInfo);
		return map;
	}

	@RequestMapping("toConsole")
	public String toWelcome(Model model) {
		Admin admin = adminService.login("root", "toor");
		VersionInformation ver = new VersionInformation();
		// 获取用户信息
		String admin_university = admin.getAdmin_univeristy();
		// 获取系统版本信息
		String sysVersionInfo = ver.getSysInfo();
		String mysqlVersionInfo = ver.getMysqlInfo();
		// 放入model
		model.addAttribute("versionInfo", sysVersionInfo);
		model.addAttribute("mysqlInfo", mysqlVersionInfo);
		model.addAttribute("adminAccount", admin.getAdmin_account());
		model.addAttribute("adminTotals", adminService.getColleagues(admin_university));
		model.addAttribute("adminUniversity", admin_university);
		return "console";
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
