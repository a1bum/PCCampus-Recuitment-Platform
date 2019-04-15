package top.a1bum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.a1bum.dao.WXUserMapper;
import top.a1bum.entity.WXUser;

@Service
public class WXUserService {
	@Autowired
	WXUserMapper wxUserMapper;
	
	public Boolean addWXUser(WXUser WXUser) {
		return wxUserMapper.addWXUser(WXUser);
	}
	
	public WXUser getWXUser(String wx_id) {
		return wxUserMapper.getWXUser(wx_id);
	}

	public String isExist(String wx_id) {
		return wxUserMapper.getWXUser(wx_id)==null?"false":"true";
	}
}
