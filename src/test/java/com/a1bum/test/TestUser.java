package com.a1bum.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.a1bum.dao.UserMapper;
import com.a1bum.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class TestUser {
	@Autowired
	UserMapper userMapper;
	
	@Test
	public void testGetUser() {
		String wx_id = "0";
		System.out.println(userMapper.getUser(wx_id));
	}
	
	@Test
	public void testAddUser() {
		User user = new User("123","123","");
		System.out.println(userMapper.addUser(user));
	}
	
}
