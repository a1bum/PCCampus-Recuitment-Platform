package top.a1bum.entity;

public class CRI
{
  private Integer id;
  private String wx_id;
  private String company_name;
  private String university_name;
  private String university_short_name;
  private String hold_date;
  private String start_time;
  private String locations;
  private String logo_url;
  private String hot;
  private String isExpired;
  private String detail;
  
  public CRI() {}
  
  public CRI(Integer id, String wx_id, String company_name, String university_name, String university_short_name,
		String hold_date, String start_time, String locations, String logo_url, String hot, String isExpired,
		String detail) {
	super();
	this.id = id;
	this.wx_id = wx_id;
	this.company_name = company_name;
	this.university_name = university_name;
	this.university_short_name = university_short_name;
	this.hold_date = hold_date;
	this.start_time = start_time;
	this.locations = locations;
	this.logo_url = logo_url;
	this.hot = hot;
	this.isExpired = isExpired;
	this.detail = detail;
}

public String toString()
  {
    return 
    
      "CRI [id=" + this.id + ", wx_id=" + this.wx_id + ", company_name=" + this.company_name + ", university_name=" + this.university_name + ", university_short_name=" + this.university_short_name + ", hold_date=" + this.hold_date + ", start_time=" + this.start_time + ", locations=" + this.locations + ", logo_url=" + this.logo_url + ", hot=" + this.hot + ", isExpired=" + this.isExpired + ", detail=" + this.detail + "]";
  }
  
  public Integer getId()
  {
    return this.id;
  }
  
  public void setId(Integer id)
  {
    this.id = id;
  }
  
  public String getWx_id()
  {
    return this.wx_id;
  }
  
  public void setWx_id(String wx_id)
  {
    this.wx_id = wx_id;
  }
  
  public String getCompany_name()
  {
    return this.company_name;
  }
  
  public void setCompany_name(String company_name)
  {
    this.company_name = company_name;
  }
  
  public String getUniversity_name()
  {
    return this.university_name;
  }
  
  public void setUniversity_name(String university_name)
  {
    this.university_name = university_name;
  }
  
  public String getUniversity_short_name()
  {
    return this.university_short_name;
  }
  
  public void setUniversity_short_name(String university_short_name)
  {
    this.university_short_name = university_short_name;
  }
  
  public String getHold_date()
  {
    return this.hold_date;
  }
  
  public void setHold_date(String hold_date)
  {
    this.hold_date = hold_date;
  }
  
  public String getStart_time()
  {
    return this.start_time;
  }
  
  public void setStart_time(String start_time)
  {
    this.start_time = start_time;
  }
  
  public String getLocations()
  {
    return this.locations;
  }
  
  public void setLocations(String locations)
  {
    this.locations = locations;
  }
  
  public String getLogo_url()
  {
    return this.logo_url;
  }
  
  public void setLogo_url(String logo_url)
  {
    this.logo_url = logo_url;
  }
  
  public String getHot()
  {
    return this.hot;
  }
  
  public void setHot(String hot)
  {
    this.hot = hot;
  }
  
  public String getIsExpired()
  {
    return this.isExpired;
  }
  
  public void setIsExpired(String isExpired)
  {
    this.isExpired = isExpired;
  }
  
  public String getDetail()
  {
    return this.detail;
  }
  
  public void setDetail(String detail)
  {
    this.detail = detail;
  }
}
