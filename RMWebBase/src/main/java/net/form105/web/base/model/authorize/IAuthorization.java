package net.form105.web.base.model.authorize;

import java.io.Serializable;

public interface IAuthorization extends Serializable {
	
	public AuthorizationState isAuthorized();

}
