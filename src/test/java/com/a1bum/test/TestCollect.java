package com.a1bum.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.a1bum.entity.Collect;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class TestCollect {
	
	@Test
	public void testAdd() {
		System.out.println(new Collect("123", "123", 1, 1, 1));
	}
}
