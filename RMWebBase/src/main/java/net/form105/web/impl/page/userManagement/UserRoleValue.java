package net.form105.web.impl.page.userManagement;

import java.util.List;

import net.form105.rm.base.model.user.User;
import net.form105.web.base.model.filter.IValue;

public class UserRoleValue implements IValue<List<String>, User> {
	
	private static final long serialVersionUID = 1L;

	public List<String> getValue(User object) {
		List<String> roleList = object.getRoles();
		return roleList;
	}

}
