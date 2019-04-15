package top.a1bum.entity;

public class WXUser
{
  private String wx_id;
  private String user_name;
  private String personal_statement;
  
  public WXUser() {}
  
  public WXUser(String wx_id, String user_name, String personal_statement)
  {
    this.wx_id = wx_id;
    this.user_name = user_name;
    this.personal_statement = personal_statement;
  }
  
  public String getWx_id()
  {
    return this.wx_id;
  }
  
  public void setWx_id(String wx_id)
  {
    this.wx_id = wx_id;
  }
  
  public String getUser_name()
  {
    return this.user_name;
  }
  
  public void setUser_name(String user_name)
  {
    this.user_name = user_name;
  }
  
  public String getPersonal_statement()
  {
    return this.personal_statement;
  }
  
  public void setPersonal_statement(String personal_statement)
  {
    this.personal_statement = personal_statement;
  }
  
  public String toString()
  {
    return "User [wx_id=" + this.wx_id + ", user_name=" + this.user_name + ", personal_statement=" + this.personal_statement + "]";
  }
}
