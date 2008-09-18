package net.form105.web.base.model.filter;

import net.form105.rm.base.model.user.User;

public class UserEmailValue<T extends User> implements IValue<String, T> {
	

	@Override
	public String getValue(T user) {
		return user.getEMail();
	}
	
	

}
