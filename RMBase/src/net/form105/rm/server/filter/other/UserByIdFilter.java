package net.form105.rm.server.filter.other;

import net.form105.rm.base.model.user.User;
import net.form105.rm.base.query.filter.IFilter;



/**
 * If the user id is the same than the provided id the filter returns true
 * @author heiko
 *
 * @param <T>
 */
public class UserByIdFilter<T extends User> implements IFilter<T> {

	private String id;
	
	public UserByIdFilter(String userId) {
		this.id = userId;
	}

	@Override
	public boolean filter(T object) {
		String userId = object.getId().toString();
		
		if (userId.equals(id)) {
			return true ;
		}
		return false;
	}

}
