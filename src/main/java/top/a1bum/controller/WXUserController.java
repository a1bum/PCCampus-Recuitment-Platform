package top.a1bum.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import top.a1bum.entity.WXUser;
import top.a1bum.service.WXUserService;
import top.a1bum.utils.WX;

@RequestMapping("WXUser")
@Controller
public class WXUserController {
	@Autowired
	WXUserService wxUserService;
	
	@ResponseBody
	@RequestMapping("isExist")
	public Map<String, Object> decrypt(@RequestParam("jscode") String jscode) throws IOException{
		Map<String, Object> map = new HashMap<>();
		String wx_id = WX.decrypt(jscode);
		System.out.println(wx_id);
//		System.out.println(wx_id);
		WXUser user = new WXUser(wx_id, "", wxUserService.isExist(wx_id));
		map.put("user", user);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("add")
	public Map<String, Object> addUser(@RequestParam("wx_id") String wx_id, @RequestParam("user_name") String user_name) {
		WXUser user = new WXUser(wx_id, user_name, "");
		Map<String, Object> map = new HashMap<>();
		map.put("result", wxUserService.addWXUser(user));
		return map;
	}
	
	@ResponseBody
	@RequestMapping("get")
	public Map<String, Object> getUser(@RequestParam("wx_id")String wx_id){
		Map<String, Object> map = new HashMap<>();
		map.put("result", wxUserService.getWXUser(wx_id));
		return map;
	}
}
