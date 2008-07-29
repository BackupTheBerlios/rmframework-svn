package net.form105.web.base.component.login.authorize;

import java.io.Serializable;

/**
 * A user which represents a not authenticated user. It should be used if the authentication process
 * fails, oder the authentication haven't started before.
 * @author hk
 *
 */
public class NoUser implements IProvidedUser, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public String getLabel() {
		return null;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUserId() {
		return null;
	}

	@Override
	public void setLabel(String label) {
	}

	@Override
	public void setPassword(String password) {
	}

	@Override
	public void setUserId(String userId) {
	}

}
