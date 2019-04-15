package top.a1bum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.a1bum.dao.AdminMapper;
import top.a1bum.entity.Admin;

@Service
public class AdminService {
	@Autowired
	AdminMapper adminMapper;

	public Admin login(String account, String password) {
		return adminMapper.login(account, password);
	}

	public Integer getColleagues(String admin_univeristy) {
		return adminMapper.getColleagues(admin_univeristy);
	}
}
