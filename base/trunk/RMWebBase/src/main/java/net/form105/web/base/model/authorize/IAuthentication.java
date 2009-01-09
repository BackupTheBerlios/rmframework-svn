package net.form105.web.base.model.authorize;

import java.io.Serializable;

import net.form105.web.base.component.login.authorize.IProvidedUser;

public interface IAuthentication extends Serializable {
	
	public boolean isAuthenticated();
	
	public IProvidedUser getUser();

}
