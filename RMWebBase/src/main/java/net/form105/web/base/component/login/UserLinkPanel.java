package net.form105.web.base.component.login;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * @author hk
 */
public class UserLinkPanel extends Panel<Void> {

	private static final long serialVersionUID = 1L;

	public UserLinkPanel(String id) {
		super(id);
		addUserLink();
	}
	
	private void addUserLink() {
		
		add(new Label<String>("userLabel", "heiko.kundlacz@gmx.net"));
		add(new Label<String>("logoutLabel", "logout"));
	}
	
	public boolean isVisible() {
		return true;
	}

}

