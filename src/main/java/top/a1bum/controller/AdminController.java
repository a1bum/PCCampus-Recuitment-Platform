package top.a1bum.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
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
import top.a1bum.utils.TCaptchaVerify;
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
		String admin_university = admin.getAdmin_univeristy();
		String sysVersionInfo = ver.getSysInfo();
		String mysqlVersionInfo = ver.getMysqlInfo();
		model.addAttribute("versionInfo", sysVersionInfo);
		model.addAttribute("mysqlInfo", mysqlVersionInfo);
		model.addAttribute("adminAccount", admin.getAdmin_account());
		model.addAttribute("adminTotals", adminService.getColleagues(admin_university));
		model.addAttribute("adminUniversity", admin_university);
		return "console";
	}

	@ResponseBody
	@RequestMapping("login")
	public Map<String, Object> login(@RequestParam("ticket")String ticket,@RequestParam("randstr") String rand,
			@RequestParam("act")String account, @RequestParam("pwd")String password) {
		InetAddress addr;
		String userIp;
		Admin loginResult; 
		Map<String, Object> map = new HashMap<>();
		try {
			addr = InetAddress.getLocalHost();
			userIp = addr.getHostAddress();
			loginResult = adminService.login(account, password);
			if(TCaptchaVerify.verifyTicket(ticket, rand, userIp) == 1 && loginResult != null) {
				map.put("result", 1);
			}else {
				map.put("result", 0);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping("toIndex")
	public String toIndex() {
		return "index";
	}
}
