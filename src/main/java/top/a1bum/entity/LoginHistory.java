package top.a1bum.entity;

public class LoginHistory {
	private Integer id;
	private String account;
	private String broswer_name;
	private String broswer_type;
	private String broswer_version;
	private String os_name;
	private String device_type;
	private String user_ip;
	private Integer login_success;
	private String login_time;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getBroswer_name() {
		return broswer_name;
	}
	public void setBroswer_name(String broswer_name) {
		this.broswer_name = broswer_name;
	}
	public String getBroswer_type() {
		return broswer_type;
	}
	public void setBroswer_type(String broswer_type) {
		this.broswer_type = broswer_type;
	}
	public String getBroswer_version() {
		return broswer_version;
	}
	public void setBroswer_version(String broswer_version) {
		this.broswer_version = broswer_version;
	}
	public String getOs_name() {
		return os_name;
	}
	public void setOs_name(String os_name) {
		this.os_name = os_name;
	}
	public String getDevice_type() {
		return device_type;
	}
	public void setDevice_type(String device_type) {
		this.device_type = device_type;
	}
	public String getUser_ip() {
		return user_ip;
	}
	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}
	public Integer getLogin_success() {
		return login_success;
	}
	public void setLogin_success(Integer login_success) {
		this.login_success = login_success;
	}
	public String getLogin_time() {
		return login_time;
	}
	public void setLogin_time(String login_time) {
		this.login_time = login_time;
	}
	public LoginHistory() {
		super();
	}
	public LoginHistory(String account, String broswer_name, String broswer_type, String broswer_version,
			String os_name, String device_type, String user_ip, Integer login_success, String login_time) {
		super();
		this.account = account;
		this.broswer_name = broswer_name;
		this.broswer_type = broswer_type;
		this.broswer_version = broswer_version;
		this.os_name = os_name;
		this.device_type = device_type;
		this.user_ip = user_ip;
		this.login_success = login_success;
		this.login_time = login_time;
	}
	@Override
	public String toString() {
		return "LoginHistory [id=" + id + ", account=" + account + ", broswer_name=" + broswer_name + ", broswer_type="
				+ broswer_type + ", broswer_version=" + broswer_version + ", os_name=" + os_name + ", device_type="
				+ device_type + ", user_ip=" + user_ip + ", login_success=" + login_success + ", login_time="
				+ login_time + "]";
	}
	
}
