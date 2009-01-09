package net.form105.web.base.model.authorize;

import java.util.HashMap;
import java.util.Map;

/**
 * Integrates some default users which the system can authorize against.
 * @author heiko
 *
 */
public class SimpleUserIntegration implements IUserIntegration {
	
	private Map<String, String> userList = new HashMap<String, String>();
	
	public SimpleUserIntegration() {
		userList.put("admin", "admin");
		userList.put("user", "user");
	}
	
	/**
	 * Get the password of the user
	 * @param userId
	 * @return
	 */
	public String getPassword(String userId) {
		return userList.get(userId);
	}
	
	/**
	 * Check if the user exists
	 * @param userId
	 * @return
	 */
	public boolean isUserAvailable(String userId) {
		if (userList.containsKey(userId)) {
			return true;
		}
		return false;
	}
	
	

}
