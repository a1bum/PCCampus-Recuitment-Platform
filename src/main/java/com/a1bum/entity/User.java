package com.a1bum.entity;

public class User {
	private String wx_id;
	private String user_name;
	private String personal_statement;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String wx_id, String user_name, String personal_statement) {
		super();
		this.wx_id = wx_id;
		this.user_name = user_name;
		this.personal_statement = personal_statement;
	}
	public String getWx_id() {
		return wx_id;
	}
	public void setWx_id(String wx_id) {
		this.wx_id = wx_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPersonal_statement() {
		return personal_statement;
	}
	public void setPersonal_statement(String personal_statement) {
		this.personal_statement = personal_statement;
	}
	@Override
	public String toString() {
		return "User [wx_id=" + wx_id + ", user_name=" + user_name + ", personal_statement=" + personal_statement + "]";
	}
	
	
}
