package com.a1bum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a1bum.dao.UserMapper;
import com.a1bum.entity.User;

@Service
public class UserService {
	@Autowired
	UserMapper userMapper;
	
	public Boolean addUser(User user) {
		return userMapper.addUser(user);
	}
	
	public User getUser(String wx_id) {
		return userMapper.getUser(wx_id);
	}

	public String isExist(String wx_id) {
		return userMapper.getUser(wx_id)==null?"false":"true";
	}
}
