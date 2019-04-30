package top.a1bum.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import top.a1bum.entity.WXServiceNotice;
import top.a1bum.entity.WXTemplateMsg;
import top.a1bum.utils.WechatApi;

@Controller
@RequestMapping("wxuser")
public class WechatController {
	
	@ResponseBody
	@RequestMapping("decrypt")
	public Map<String, Object> getOpenIdByJSCode(String jscode){
		Map<String, Object> map = new HashMap<>();
		map.put("openid", WechatApi.getOpenIdByJSCode(jscode));
		return map;
	}
	
	@ResponseBody
	@RequestMapping("collect")
	public Map<String, Object> templateSend(@RequestParam("openid")String openid, 
			@RequestParam("formId")String formId, 
			@RequestParam("company_name")String company_name,
			@RequestParam("university_name")String university_name,
			@RequestParam("hold_date")String hold_date,
			@RequestParam("start_time")String start_time,
			@RequestParam("locations")String locations){
		Map<String, Object> map = new HashMap<>();
		Map<String, WXTemplateMsg> dataMap = new HashMap<>();
		WXTemplateMsg keyword1 = new WXTemplateMsg(company_name);
		dataMap.put("keyword1", keyword1);
		WXTemplateMsg keyword2 = new WXTemplateMsg(hold_date);
		dataMap.put("keyword2", keyword2);
		WXTemplateMsg keyword3 = new WXTemplateMsg(start_time);
		dataMap.put("keyword3", keyword3);
		WXTemplateMsg keyword4 = new WXTemplateMsg(locations);
		dataMap.put("keyword4", keyword4);
		WXServiceNotice serviceNotice = new WXServiceNotice(openid, formId, "LL1hyGQ5J0k5n38fOqv3OJgNz8Zxp_jivXxaYZXM120", dataMap);
		// 设置定时任务
		Timer timer = new Timer();
		TimerTask timeTask = new TimerTask() {
			@Override
			public void run() {
				WechatApi.templateSend(WechatApi.getAccessToken(),serviceNotice);
			}
		};
		// 获取延时
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long gap = 0;
		try {
			gap = sdf.parse(hold_date + " " + start_time).getTime() - System.currentTimeMillis()-30*60*1000;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(gap);
		timer.schedule(timeTask, gap);
		map.put("code", 0);
		return map;
	}
}
