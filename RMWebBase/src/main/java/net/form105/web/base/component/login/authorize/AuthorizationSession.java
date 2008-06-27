package net.form105.web.base.component.login.authorize;

import net.form105.web.base.IType;

import org.apache.wicket.Request;
import org.apache.wicket.protocol.http.WebSession;

public class AuthorizationSession extends WebSession {

	private static final long serialVersionUID = 1L;
	
	private IProvidedUser user;
	private IType state = new NotAuthorizedState();
	
	public AuthorizationSession(Request request) {
		super(request);
	}

	

}
