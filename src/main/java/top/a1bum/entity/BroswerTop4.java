package top.a1bum.entity;

public class BroswerTop4 {
	private String broswer_name;
	private Integer broswer_count;
	public String getBroswer_name() {
		return broswer_name;
	}
	public void setBroswer_name(String broswer_name) {
		this.broswer_name = broswer_name;
	}
	public Integer getBroswer_count() {
		return broswer_count;
	}
	public void setBroswer_count(Integer broswer_count) {
		this.broswer_count = broswer_count;
	}
	public BroswerTop4() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BroswerTop4(String broswer_name, Integer broswer_count) {
		super();
		this.broswer_name = broswer_name;
		this.broswer_count = broswer_count;
	}
	@Override
	public String toString() {
		return "BroswerTop5 [broswer_name=" + broswer_name + ", broswer_count=" + broswer_count + "]";
	}
	
}
