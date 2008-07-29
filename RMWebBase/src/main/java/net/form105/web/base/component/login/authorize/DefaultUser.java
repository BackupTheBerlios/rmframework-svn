package net.form105.web.base.component.login.authorize;

import java.io.Serializable;

/**
 * If a user want to login this user is the model which can be used to authenticate against a backend system. 
 * @author heiko
 *
 */
public class DefaultUser implements IProvidedUser, Serializable {

	private static final long serialVersionUID = 1L;
	
	private String userId;
	private String password;
	private String label;
	
	public DefaultUser() {
	}
	
	public DefaultUser(String id, String password, String label) {
		this.userId = id;
		this.password = password;
		this.label = label;
	}
	
	/**
	 * Constructor for same entry of id and label
	 * @param id
	 * @param password
	 */
	public DefaultUser(String id, String password) {
		this(id, password, id);
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
