package net.form105.rm.base.model.user;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Representation of a list of users backed by a HashMap. All methods are synchronized.
 * 
 * @author HK
 * 
 */
public class UserList {

	private Map<Long, User> users = new HashMap<Long, User>();

	public synchronized Map<Long, User> getUsers() {
		return users;
	}

	public synchronized void setUsers(Map<Long, User> users) {
		this.users = users;
	}

	public synchronized void addUser(Long key, User user) {
		users.put(key, user);
	}
	
	public synchronized void removeUser(String key) {
		users.remove(key);
	}
	
	public synchronized Collection<User> getUsersAsList() {
		return users.values();
	}
	
	public synchronized User getUserById(Long id) {
		return users.get(id);
	}

}
