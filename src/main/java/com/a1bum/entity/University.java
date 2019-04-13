package com.a1bum.entity;

public class University {
	private String university_id;
	private String university_name;
	private String department;
	private String city;
	private String university_official;
	private String is_register;
	
	public University() {
		super();
	}

	public University(String university_id, String university_name, String department, String city,
			String university_official, String is_register) {
		super();
		this.university_id = university_id;
		this.university_name = university_name;
		this.department = department;
		this.city = city;
		this.university_official = university_official;
		this.is_register = is_register;
	}

	public String getUniversity_id() {
		return university_id;
	}

	public void setUniversity_id(String university_id) {
		this.university_id = university_id;
	}

	public String getUniversity_name() {
		return university_name;
	}

	public void setUniversity_name(String university_name) {
		this.university_name = university_name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUniversity_official() {
		return university_official;
	}

	public void setUniversity_official(String university_official) {
		this.university_official = university_official;
	}

	public String getIs_register() {
		return is_register;
	}

	public void setIs_register(String is_register) {
		this.is_register = is_register;
	}

	@Override
	public String toString() {
		return "University [university_id=" + university_id + ", university_name=" + university_name + ", department="
				+ department + ", city=" + city + ", university_official=" + university_official + ", is_register="
				+ is_register + "]";
	}
}
