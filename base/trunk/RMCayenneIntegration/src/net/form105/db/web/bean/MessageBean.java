package net.form105.db.web.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="sampleBean")
public class MessageBean {
	
	public String getMessage() {
		return "this is a message";
	}

}
