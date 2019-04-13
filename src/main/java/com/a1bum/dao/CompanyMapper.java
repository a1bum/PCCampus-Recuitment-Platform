package com.a1bum.dao;

import com.a1bum.entity.Company;

public interface CompanyMapper {
	public abstract Boolean addCompany(Company company);
	public abstract Company getByCompanyName(String company_name);
}
