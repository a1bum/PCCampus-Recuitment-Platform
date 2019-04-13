package com.a1bum.dao;

import com.a1bum.entity.User;

public interface UserMapper {
	public abstract Boolean addUser(User user);
	public abstract User getUser(String wx_id);
}
