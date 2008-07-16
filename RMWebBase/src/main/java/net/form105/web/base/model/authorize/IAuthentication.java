package net.form105.web.base.model.authorize;

import java.io.Serializable;

public interface IAuthentication extends Serializable {
	
	public AuthenticationState isAuthenticated();

}
