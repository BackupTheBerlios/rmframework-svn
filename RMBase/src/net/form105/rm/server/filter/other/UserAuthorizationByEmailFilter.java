package net.form105.rm.server.filter.other;

import net.form105.rm.base.model.user.User;
import net.form105.rm.base.query.filter.IFilter;

import org.apache.log4j.Logger;

/**
 * Filters a user by its email addresse
 * @author heiko
 *
 * @param <T>
 */
public class UserAuthorizationByEmailFilter<T extends User> implements IFilter<User> {
	
	private static final long serialVersionUID = 1L;
	public static Logger logger = Logger.getLogger(UserAuthorizationByEmailFilter.class);
	private String email;
	private String passwd;
	
	public UserAuthorizationByEmailFilter(String email, String passwd) {
		this.email = email;
		this.passwd = passwd;
	}

	@Override
	public boolean filter(User object) {
		
		logger.info("Running filter on user: "+object.getId());
		
		if (object.getPassword() == null) return false;
		if (object.getEMail() == null) return false;
		
		boolean isEmail = object.getEMail().equals(email);
		boolean isPasswd = object.getPassword().equals(passwd);
		
		
		
		if (isEmail && isPasswd) {
			return true;
		}
		
		return false;
	}

}
