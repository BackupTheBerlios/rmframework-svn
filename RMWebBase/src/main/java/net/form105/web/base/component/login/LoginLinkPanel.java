package net.form105.web.base.component.login;

import net.form105.web.base.ApplicationSession;
import net.form105.web.base.model.authorize.AuthenticationState;
import net.form105.web.base.page.login.LoginPage;

import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.ResourceModel;

public class LoginLinkPanel extends Panel<Object> {
	
	public static Logger logger = Logger.getLogger(LoginLinkPanel.class);
	
	private static final long serialVersionUID = 1L;

	public LoginLinkPanel(String id) {
		super(id);
		addLoginLink();
	}
	
	private void addLoginLink() {
		ResourceModel rModel = new ResourceModel("menu.mainNav.login");
		BookmarkablePageLink loginPageLink = new BookmarkablePageLink("loginItem", LoginPage.class);
		loginPageLink.add(new Label<String>("loginLabel", rModel));
		add(loginPageLink);
	}
	
	public boolean isVisible() {
		ApplicationSession session = (ApplicationSession) getSession();
		return session.getAuthentication().isAuthenticated() == AuthenticationState.NOTAUTHORIZED;
	}
}
