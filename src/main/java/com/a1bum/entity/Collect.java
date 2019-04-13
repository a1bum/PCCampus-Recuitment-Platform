package com.a1bum.entity;

public class Collect {
	private Integer id;
	private String wx_id;
	private String cri_id;
	private Integer sms;
	private Integer isValid;
	private Integer isExpired;
	public String getWx_id() {
		return wx_id;
	}
	public void setWx_id(String wx_id) {
		this.wx_id = wx_id;
	}
	public String getCri_id() {
		return cri_id;
	}
	public void setCri_id(String cri_id) {
		this.cri_id = cri_id;
	}
	public Integer getSms() {
		return sms;
	}
	public void setSms(Integer sms) {
		this.sms = sms;
	}
	public Integer getIsValid() {
		return isValid;
	}
	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}
	public Integer getIsExpired() {
		return isExpired;
	}
	public void setIsExpired(Integer isExpired) {
		this.isExpired = isExpired;
	}
	public Collect() {
		super();
	}
	public Collect(String wx_id, String cri_id, Integer sms, Integer isValid, Integer isExpired) {
		super();
		this.wx_id = wx_id;
		this.cri_id = cri_id;
		this.sms = sms;
		this.isValid = isValid;
		this.isExpired = isExpired;
	}
	@Override
	public String toString() {
		return "Collect [id=" + id + ", wx_id=" + wx_id + ", cri_id=" + cri_id + ", sms=" + sms + ", isValid=" + isValid
				+ ", isExpired=" + isExpired + "]";
	}
	
}
