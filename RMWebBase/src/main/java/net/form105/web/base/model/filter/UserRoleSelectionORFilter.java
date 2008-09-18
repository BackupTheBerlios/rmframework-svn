package net.form105.web.base.model.filter;

import java.util.List;

import net.form105.rm.base.model.user.User;

public class UserRoleSelectionORFilter<T extends User> extends AbstractUIFilter<T> {
	
	private static final long serialVersionUID = 1L;
	private List<String> roles;

	@Override
	public boolean filter(T object) {
		for (String role : roles) {
			
			List<String> rolesOfUser = object.getRoles();
			
			for (String roleOfUser : rolesOfUser) {
				if (role.equals(roleOfUser)) {
					return true;
				}
			}
			
		}
		return false;
	}
	
	public String getId() {
		return "USER_ROLE_SELECTION_FILTER";
	}

}
