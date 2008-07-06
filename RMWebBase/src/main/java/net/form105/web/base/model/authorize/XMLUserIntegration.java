package net.form105.web.base.model.authorize;

import com.form105.rm.base.model.user.User;

public class XMLUserIntegration implements IUserIntegration {
	
	
	public void addUser(String key, User user) {
		
	}
	

	@Override
	public String getPassword(String userId) {
		
		return null;
	}

	@Override
	public boolean isUserAvailable(String userId) {
		
		return false;
	}
	
	public void load(String filename) {
		
		
	}
	
	

}
