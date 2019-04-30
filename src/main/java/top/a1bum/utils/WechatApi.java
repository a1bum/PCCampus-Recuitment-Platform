package top.a1bum.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.hutool.http.HttpRequest;
import top.a1bum.entity.WXServiceNotice;

public class WechatApi {
	static String url = null;
	static String inputLine = null;
	
	public static String templateSend(String access_token,WXServiceNotice serviceNotice) {
		String url = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=" + access_token;
		String body = HttpRequest.post(url).body(JSON.toJSONString(serviceNotice)).execute().body();
		JSONObject jsonObj = JSON.parseObject(body);
		return jsonObj.getString("errcode");
	}

	public static String getAccessToken() {
		String apiurl = "https://api.weixin.qq.com/cgi-bin/token?"
				+ "grant_type=client_credential&appid=wxf510a2262ffb3945"
				+ "&secret=7895cb72af5d703d2db983808710618c";
		String body = HttpRequest.get(apiurl).execute().body();
		JSONObject jsonObj = JSON.parseObject(body);
		return jsonObj.getString("access_token");
	}

	public static String getOpenIdByJSCode(String jscode) {
		String apiurl = "https://api.weixin.qq.com/sns/jscode2session?appid=wxf510a2262ffb3945" 
				+ "&secret=7895cb72af5d703d2db983808710618c"
				+ "&js_code=" + jscode + "&grant_type=authorization_code";
		String body = HttpRequest.get(apiurl).execute().body();
		JSONObject jsonObj = JSON.parseObject(body);
		return jsonObj.getString("openid");
	}
}
