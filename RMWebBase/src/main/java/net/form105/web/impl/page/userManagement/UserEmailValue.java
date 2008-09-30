package net.form105.web.impl.page.userManagement;

import net.form105.rm.base.model.user.User;
import net.form105.web.base.model.filter.IValue;

public class UserEmailValue implements IValue<String, User> {
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getValue(User user) {
		return user.getEMail();
	}
	
	

}
