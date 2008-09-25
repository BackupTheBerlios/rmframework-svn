package net.form105.web.base.model.filter;

import net.form105.rm.base.model.user.User;

public class UserEmailValue<T extends User> implements IValue<String, T> {
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getValue(T user) {
		return user.getEMail();
	}
	
	

}
