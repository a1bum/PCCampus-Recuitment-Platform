package com.a1bum.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.a1bum.dao.UniversityMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class TestUniversity {

	@Autowired
	UniversityMapper universityMapper;
	
	@Test
	public void testGetAll() {
		System.out.println(universityMapper.getAll());
	}
	
	@Test
	public void testGetByKeyword() {
		System.out.println(universityMapper.getByKeyword("北京"));
	}
	
	@Test
	public void testGetByCampusName() {
		System.out.println(universityMapper.getByUniversityName("北京大学"));
	}
}
