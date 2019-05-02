package top.a1bum.dao;

import java.util.List;

import top.a1bum.entity.BroswerTop4;
import top.a1bum.entity.LoginHistory;

public interface LoginHistoryMapper {
	public Integer addLoginHistory(LoginHistory history);

	public List<BroswerTop4> getTop4ByBroswer();

	public Integer getAll();
}
