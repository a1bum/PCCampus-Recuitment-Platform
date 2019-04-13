package com.a1bum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a1bum.dao.AdminMapper;
import com.a1bum.entity.Admin;

@Service
public class AdminService {
	@Autowired
	AdminMapper adminMapper;
	
	public Admin login(String account, String password) {
		return adminMapper.login(account, password);
	}
	
}
