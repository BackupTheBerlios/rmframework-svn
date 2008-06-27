package net.form105.web.base.model.authorize;

import net.form105.web.base.component.login.authorize.IProvidedUser;

public class Authorization implements IAuthorization {
	
	private IProvidedUser user;
	
	public Authorization(IProvidedUser user) {
		this.user = user;
		
	}

	@Override
	public AuthorizationState isAuthorized() {
		// delegate to CredentialHandler
		
		
		return null;
	}

}
