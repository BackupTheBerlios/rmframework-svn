package net.form105.web.base.component.login;

import org.apache.wicket.markup.html.panel.Panel;

/**
 * @author heiko
 */
public class UserSwitchPanel extends Panel {
	
	private static final long serialVersionUID = 1L;

	public UserSwitchPanel(String id) {
		super(id);
		add(new LoginLinkPanel("panel.loginLink"));
		add(new UserLinkPanel("panel.userLink"));
	}

}

