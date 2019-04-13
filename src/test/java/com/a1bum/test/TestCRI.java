package com.a1bum.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.a1bum.dao.CRIMapper;
import com.a1bum.entity.CRI;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class TestCRI {

	@Autowired
	private CRIMapper criMapper;
	
	@Test
	public void testGetAll() {
		System.out.println(criMapper.getAll());
	}
	
	@Test
	public void getByKeyword() {
		System.out.println(criMapper.getByKeyword("兰大", "2019-04-11"));
	}
	
	@Test
	public void testAddCRI() {
		CRI cri = new  CRI("公司名称", "公司url", "举办日前", "开始时间", "结束时间", "举办学校", "详细地址");
		System.out.println(criMapper.addCRI(cri));
	}
	
	@Test
	public void testGetByDate() {
		System.out.println(criMapper.getByDate("2018-04-08"));
	}
}
