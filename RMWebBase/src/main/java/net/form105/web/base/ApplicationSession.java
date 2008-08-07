package net.form105.web.base;

import net.form105.rm.base.lookup.ILookup;
import net.form105.rm.base.model.user.User;
import net.form105.rm.base.service.IResult;
import net.form105.rm.base.service.Status;
import net.form105.web.base.action.AuthenticationAction;
import net.form105.web.base.component.login.authorize.NoUser;
import net.form105.web.base.lookup.UserLookupRegistry;
import net.form105.web.base.model.authorize.Authentication;

import org.apache.wicket.Request;
import org.apache.wicket.authentication.AuthenticatedWebSession;
import org.apache.wicket.authorization.strategies.role.Roles;

/**
 * The application session holds the information needed that are needed longer than a browser request. Each variable represents
 * such an information. By default the ApplicationSession creates an Authentication object with a default NoUser.
 * @author hk
 *
 */
public class ApplicationSession extends AuthenticatedWebSession {
	
	Authentication authentication;
	UserLookupRegistry lookup = new UserLookupRegistry();

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
	
	public ILookup getLookup() {
		return lookup;
	}

	@Override
	public boolean authenticate(String username, String password) {
		AuthenticationAction action = new AuthenticationAction(username, password);
		IResult<User> result = action.doAction();
		return result.getStatus() == Status.SUCCESS;
	}

	@Override
	public Roles getRoles() {
		if (authentication.getUser().getRoles() != null) {
			Roles roles = new Roles();
			roles.addAll(authentication.getUser().getRoles());
			return roles;
		}
		
		
		return null;
	}
}
