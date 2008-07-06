package com.form105.rm.base.model.user;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Representation of a list of users backed by a HashMap. All methods are synchronized.
 * 
 * @author HK
 * 
 */
public class UserList {

	private Map<String, User> users = Collections.synchronizedMap(new HashMap<String, User>());

	public synchronized Map<String, User> getUsers() {
		return users;
	}

	public synchronized void setUsers(Map<String, User> users) {
		this.users = users;
	}

	public synchronized void addUser(String key, User user) {
		users.put(key, user);
	}
	
	public synchronized void removeUser(String key) {
		users.remove(key);
	}
	
	public synchronized Collection<User> getUsersAsList() {
		return users.values();
	}
	
	public synchronized User getUserById(String id) {
		return users.get(id);
	}

}
