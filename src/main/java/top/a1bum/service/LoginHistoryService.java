package top.a1bum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.a1bum.dao.LoginHistoryMapper;
import top.a1bum.entity.BroswerTop4;
import top.a1bum.entity.LoginHistory;

@Service
public class LoginHistoryService {
	@Autowired
	LoginHistoryMapper historyMapper;
	
	public Integer addLoginHistoryMapper(LoginHistory history){
		return historyMapper.addLoginHistory(history);
	}

	public List<BroswerTop4> getTop4ByBroswer() {
		return historyMapper.getTop4ByBroswer();
	}

	public Integer getAll() {
		return historyMapper.getAll();
	}
}
