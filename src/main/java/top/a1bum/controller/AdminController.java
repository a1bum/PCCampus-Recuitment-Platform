package top.a1bum.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import top.a1bum.entity.Admin;
import top.a1bum.entity.LoginHistory;
import top.a1bum.service.AdminService;
import top.a1bum.utils.TCaptchaVerify;
import top.a1bum.utils.VersionInformation;

@RequestMapping("admin")
@Controller
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@RequestMapping("reset_pass")
	public String showResetPass() {
		return "user/reset-pass";
	}

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
	public Map<String, Object> getSysInfo() {
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
		return "admin/console";
	}

	@RequestMapping("login")
	public String login(@RequestParam("ticket") String ticket, @RequestParam("randstr") String rand,
			@RequestParam("act") String account, @RequestParam("pwd") String password, HttpServletRequest request,
			Model model) {
		String agent = request.getHeader("User-Agent");
		// 解析agent字符串
		UserAgent userAgent = UserAgent.parseUserAgentString(agent);
		// 获取浏览器对象
		Browser browser = userAgent.getBrowser();
		// 获取操作系统对象
		OperatingSystem operatingSystem = userAgent.getOperatingSystem();
		// 执行操作并处理异常
		Integer result = 0;
		try {
			InetAddress addr = InetAddress.getLocalHost();
			String userIp = addr.getHostAddress();
			Admin loginResult = adminService.login(account, password);
			if (TCaptchaVerify.verifyTicket(ticket, rand, userIp) == 1 && loginResult != null) {
				result = 1;
			} else {
				result = 0;
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		// 生成loginhistofy对象
		LoginHistory history = new LoginHistory(account, browser.getName(), browser.getBrowserType().toString(),
				userAgent.getBrowserVersion().toString(), operatingSystem.getName(), 
				operatingSystem.getDeviceType().toString(), request.getRemoteAddr(), 
				result, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		// 添加参数
		request.setAttribute("LoginHistory", history);
		return "forward:/login/add";
	}

	@RequestMapping("toIndex")
	public String toIndex() {
		return "admin/admin-index";
	}
}
