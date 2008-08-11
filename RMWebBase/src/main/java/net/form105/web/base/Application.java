package net.form105.web.base;

import net.form105.web.base.model.authorize.Authentication;
import net.form105.web.impl.page.login.LoginPage;

import org.apache.wicket.Request;
import org.apache.wicket.Response;
import org.apache.wicket.Session;
import org.apache.wicket.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authentication.AuthenticatedWebSession;
import org.apache.wicket.authorization.strategies.page.SimplePageAuthorizationStrategy;
import org.apache.wicket.markup.html.WebPage;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see com.form105.Start#main(String[])
 */
public class Application extends AuthenticatedWebApplication {
	/**
	 * Constructor
	 */
	public Application() {

	}

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	public Class<HomePage> getHomePage() {
		return HomePage.class;
	}

	@Override
	public Session newSession(Request request, Response response) {
		Session session = new ApplicationSession(request);
		return session;
	}

	@Override
	protected Class<? extends WebPage> getSignInPageClass() {
		return LoginPage.class;
	}

	@Override
	protected Class<? extends AuthenticatedWebSession> getWebSessionClass() {
		return ApplicationSession.class;
	}

}
