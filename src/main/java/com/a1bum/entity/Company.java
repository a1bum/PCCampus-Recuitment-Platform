package com.a1bum.entity;

public class Company {

	private String company_id;
	private String company_name;
	private String company_official;
	private String company_employment;
	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getCompany_official() {
		return company_official;
	}
	public void setCompany_official(String company_official) {
		this.company_official = company_official;
	}
	public String getCompany_employment() {
		return company_employment;
	}
	public void setCompany_employment(String company_employment) {
		this.company_employment = company_employment;
	}
	public Company(String company_id, String company_name, String company_official, String company_employment) {
		super();
		this.company_id = company_id;
		this.company_name = company_name;
		this.company_official = company_official;
		this.company_employment = company_employment;
	}
	public Company() {
		super();
	}
	@Override
	public String toString() {
		return "Company [company_id=" + company_id + ", company_name=" + company_name + ", company_official="
				+ company_official + ", company_employment=" + company_employment + "]";
	}
	
	
	
}
