package com.a1bum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a1bum.dao.CompanyMapper;
import com.a1bum.entity.Company;

@Service
public class CompanyService {

	@Autowired
	CompanyMapper companyMapper;
	
	public Boolean isExist(String company_name) {
		Company company = companyMapper.getByCompanyName(company_name);
		return company!=null?true:false;
	}

}
