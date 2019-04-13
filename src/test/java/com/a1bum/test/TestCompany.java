package com.a1bum.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.a1bum.dao.CompanyMapper;
import com.a1bum.entity.Company;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class TestCompany {
	@Autowired
	CompanyMapper companyMapper;
	
	@Test
	public void testIsExist() {
		Company company = companyMapper.getByCompanyName("甘肃银行");
		if(company != null) {
			System.out.println(company);
		}else {
			System.out.println("该项为新值");
		}
	}
	
	@Test
	public void testAddCompany() {
		Company company = new Company();
		company.setCompany_employment("");
	}
}
