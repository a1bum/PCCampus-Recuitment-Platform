package com.a1bum.entity;

import javax.validation.constraints.NotNull;

public class CRI {
	@NotNull
	private Integer id;
	@NotNull
	private String wx_id;
	@NotNull
	private String company_name;
	@NotNull
	private String university_name;
	@NotNull
	private String hold_date;
	@NotNull
	private String start_time;
	@NotNull
	private String locations;
	@NotNull
	private String logo_url;

	public CRI() {
		super();
	}

	public CRI(String wx_id, String company_name, String university_name, String hold_date, String start_time,
			String locations, String logo_url) {
		super();
		this.wx_id = wx_id;
		this.company_name = company_name;
		this.university_name = university_name;
		this.hold_date = hold_date;
		this.start_time = start_time;
		this.locations = locations;
		this.logo_url = logo_url;
	}

	public String getWx_id() {
		return wx_id;
	}

	public void setWx_id(String wx_id) {
		this.wx_id = wx_id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getUniversity_name() {
		return university_name;
	}

	public void setUniversity_name(String university_name) {
		this.university_name = university_name;
	}

	public String getHold_date() {
		return hold_date;
	}

	public void setHold_date(String hold_date) {
		this.hold_date = hold_date;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getLocations() {
		return locations;
	}

	public void setLocations(String locations) {
		this.locations = locations;
	}

	public String getLogo_url() {
		return logo_url;
	}

	public void setLogo_url(String logo_url) {
		this.logo_url = logo_url;
	}

	@Override
	public String toString() {
		return "CRI [id=" + id + ", wx_id=" + wx_id + ", company_name=" + company_name + ", university_name="
				+ university_name + ", hold_date=" + hold_date + ", start_time=" + start_time + ", locations="
				+ locations + ", logo_url=" + logo_url + "]";
	}

}
