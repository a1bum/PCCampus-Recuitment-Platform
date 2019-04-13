package com.a1bum.entity;

public class Admin {
	private Integer admin_id;
	private String admin_account;
	private String admin_username;
	private String admin_password;
	private String admin_department;
	private String admin_position;
	private String admin_description;
	public Admin() {
		super();
	}
	public Admin(String admin_account, String admin_username, String admin_password, String admin_department,
			String admin_position, String admin_description) {
		super();
		this.admin_account = admin_account;
		this.admin_username = admin_username;
		this.admin_password = admin_password;
		this.admin_department = admin_department;
		this.admin_position = admin_position;
		this.admin_description = admin_description;
	}
	public String getAdmin_account() {
		return admin_account;
	}
	public void setAdmin_account(String admin_account) {
		this.admin_account = admin_account;
	}
	public String getAdmin_username() {
		return admin_username;
	}
	public void setAdmin_username(String admin_username) {
		this.admin_username = admin_username;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	public String getAdmin_department() {
		return admin_department;
	}
	public void setAdmin_department(String admin_department) {
		this.admin_department = admin_department;
	}
	public String getAdmin_position() {
		return admin_position;
	}
	public void setAdmin_position(String admin_position) {
		this.admin_position = admin_position;
	}
	public String getAdmin_description() {
		return admin_description;
	}
	public void setAdmin_description(String admin_description) {
		this.admin_description = admin_description;
	}
	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", admin_account=" + admin_account + ", admin_username=" + admin_username
				+ ", admin_password=" + admin_password + ", admin_department=" + admin_department + ", admin_position="
				+ admin_position + ", admin_description=" + admin_description + "]";
	}
	
	
}
