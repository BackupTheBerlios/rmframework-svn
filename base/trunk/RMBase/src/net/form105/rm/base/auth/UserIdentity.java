package net.form105.rm.base.auth;

import net.form105.rm.base.model.user.User;

public class UserIdentity extends AbstractIdentity {
	
	private static final long serialVersionUID = 1L;
	
	private User user;
	
	public UserIdentity(User user) {
		super(user.getId(), user.getMandate());
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
}
