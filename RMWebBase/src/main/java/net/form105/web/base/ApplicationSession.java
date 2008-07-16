package net.form105.web.base;

import net.form105.web.base.component.login.authorize.NoUser;
import net.form105.web.base.model.authorize.Authentication;

import org.apache.wicket.Request;
import org.apache.wicket.protocol.http.WebSession;

/**
 * The application session holds the information needed that are needed longer than a browser request. Each variable represents
 * such an information. By default the ApplicationSession creates an Authentication object with a default NoUser.
 * @author hk
 *
 */
public class ApplicationSession extends WebSession {
	
	Authentication authentication;

	private static final long serialVersionUID = 1L;
	
	public ApplicationSession(Request request) {
		super(request);
		authentication = new Authentication(new NoUser());
	}

	/**
	 * Getting the authentication which holds some user information
	 * @return
	 */
	public Authentication getAuthentication() {
		return authentication;
	}

	/**
	 * Setting the authorization which holds some user information
	 * @param authorization
	 */
	public void setAuthentication(Authentication authorization) {
		this.authentication = authorization;
	}
}
