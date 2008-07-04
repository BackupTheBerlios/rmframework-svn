package net.form105.web.base.model.authorize;

import net.form105.web.base.component.login.authorize.IProvidedUser;

public class Authorization implements IAuthorization {
	
	private static final long serialVersionUID = 1L;
	
	private IProvidedUser user;
	
	public Authorization(IProvidedUser user) {
		this.user = user;
		
	}

	@Override
	public AuthorizationState isAuthorized() {
		// TODO: delegate to CredentialHandler
		
		return AuthorizationState.AUTHORIZED;
	}

}
