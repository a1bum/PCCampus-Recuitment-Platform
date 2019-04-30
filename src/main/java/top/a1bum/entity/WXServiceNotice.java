package top.a1bum.entity;

import java.util.Map;

public class WXServiceNotice {
	private String touser;
	private String form_id;
	private String template_id; 
	private Map<String, WXTemplateMsg> data; 
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	
	public String getForm_id() {
		return form_id;
	}
	public void setForm_id(String form_id) {
		this.form_id = form_id;
	}
	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
	public Map<String, WXTemplateMsg> getData() {
		return data;
	}
	public void setData(Map<String, WXTemplateMsg> data) {
		this.data = data;
	}
	public WXServiceNotice() {
		super();
	}
	public WXServiceNotice(String touser, String form_id, String template_id,
			Map<String, WXTemplateMsg> data) {
		super();
		this.touser = touser;
		this.form_id = form_id;
		this.template_id = template_id;
		this.data = data;
	}
	@Override
	public String toString() {
		return "WXServiceNotice [touser=" + touser + ", form_id=" + form_id + ", template_id=" + template_id
				 + ", data=" + data + "]";
	}
	
	
}
