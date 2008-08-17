package net.form105.rm.server.filter.other;

import net.form105.rm.base.model.user.User;
import net.form105.rm.base.query.filter.IFilter;

import org.apache.log4j.Logger;

public class UserAuthorizationFilter<T extends User> implements IFilter<User> {
	
	private static final long serialVersionUID = 1L;
	public static Logger logger = Logger.getLogger(UserAuthorizationFilter.class);
	private Long userId;
	private String passwd;
	
	public UserAuthorizationFilter(Long userId, String passwd) {
		this.userId = userId;
		this.passwd = passwd;
	}

	@Override
	public boolean filter(User object) {
		
		logger.info("Running filter on user: "+object.getId());
		
		if (object.getPassword() == null) return false;
		
		boolean isUser = object.getId().equals(userId);
		boolean isPasswd = object.getPassword().equals(passwd);
		
		
		
		if (isUser && isPasswd) {
			return true;
		}
		
		return false;
	}

}
