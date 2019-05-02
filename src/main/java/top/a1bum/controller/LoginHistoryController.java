package top.a1bum.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import top.a1bum.entity.BroswerTop4;
import top.a1bum.entity.LoginHistory;
import top.a1bum.service.LoginHistoryService;

@RequestMapping("login")
@Controller
public class LoginHistoryController {
	@Autowired
	LoginHistoryService historyService;
	
	@ResponseBody
	@RequestMapping("add")
	public Map<String, Object> addLoginHistory(HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		LoginHistory history = (LoginHistory) request.getAttribute("LoginHistory");
		historyService.addLoginHistoryMapper(history);
		map.put("result", history.getLogin_success());
		System.out.println(history);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("broswer")
	public Map<String, Object> getBroswerStatistic(){
		Map<String, Object> map = new HashMap<>();
		Integer top4Total = 0;
		List<BroswerTop4> list = historyService.getTop4ByBroswer();
		for(int i=1;i<=4;i++) {
			map.put("top" + i, list.get(i-1).getBroswer_name());
			map.put("top"+ i + "Value", list.get(i-1).getBroswer_count());
			top4Total += list.get(i-1).getBroswer_count();
		}
		Integer othersValue = historyService.getAll()-top4Total;
		map.put("othersValue", othersValue);
		System.out.println(map);
		return map;
	}
}
