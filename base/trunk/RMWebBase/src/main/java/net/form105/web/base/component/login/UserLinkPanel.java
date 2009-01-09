package net.form105.web.base.component.login;

import net.form105.web.base.ApplicationSession;
import net.form105.web.base.component.login.authorize.NoUser;
import net.form105.web.base.model.authorize.Authentication;

import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.ResourceModel;

/**
 * @author hk
 */
public class UserLinkPanel extends Panel {

	private static final long serialVersionUID = 1L;

	public static Logger logger = Logger.getLogger(UserLinkPanel.class);

	public UserLinkPanel(String id) {
		super(id);
		addUserLink();
	}

	private void addUserLink() {

		ApplicationSession session = (ApplicationSession) getSession();
		String userLabel = session.getAuthentication().getUser().getLabel();
		
		add(new Label("userLabel", userLabel));

		
		Link logoutLink = new Link("logoutLink") {
			public void onClick() {
				ApplicationSession session = (ApplicationSession) getSession();
				session.setAuthentication(new Authentication(new NoUser()));
			}
		};

		logoutLink.add(new Label("logoutLabel",new ResourceModel("menu.mainNav.logout")));
		
		add(logoutLink);
	}

	public boolean isVisible() {
		ApplicationSession session = (ApplicationSession) getSession();
		if (session.getAuthentication() == null) {
			return false;
		}
		return session.getAuthentication().isAuthenticated();
	}

}
