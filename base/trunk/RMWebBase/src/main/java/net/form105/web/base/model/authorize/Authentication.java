package net.form105.web.base.model.authorize;

import net.form105.web.base.component.login.authorize.IProvidedUser;
import net.form105.web.base.component.login.authorize.NoUser;

/**
 * A simple authentication class which returns an authentication state. 
 * @author hk
 *
 */
public class Authentication implements IAuthentication {
	
	private static final long serialVersionUID = 1L;
	
	private IProvidedUser user;
	
	public Authentication(IProvidedUser user) {
		this.user = user;
		
	}

	@Override
	public boolean isAuthenticated() {
		
		if (user instanceof NoUser) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public IProvidedUser getUser() {
		return user;
	}
	
	

}
