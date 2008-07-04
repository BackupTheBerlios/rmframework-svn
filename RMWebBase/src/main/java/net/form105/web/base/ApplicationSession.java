package net.form105.web.base;

import net.form105.web.base.model.authorize.Authorization;

import org.apache.wicket.Request;
import org.apache.wicket.protocol.http.WebSession;

public class ApplicationSession extends WebSession {
	
	Authorization authorization;

	private static final long serialVersionUID = 1L;
	
	public ApplicationSession(Request request) {
		super(request);
	}

	public Authorization getAuthorization() {
		return authorization;
	}

	public void setAuthorization(Authorization authorization) {
		this.authorization = authorization;
	}

}
