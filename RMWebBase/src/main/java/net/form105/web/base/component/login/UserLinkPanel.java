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
		BookmarkablePageLink userPageLink = new BookmarkablePageLink("userItem", LoginPage.class) {
			public boolean isVisible() {
				return true;
			}
		};
		userPageLink.add(new Label<String>("userLabel", "heiko.kundlacz@gmx.net"));
		add(userPageLink);
	}
	
	public boolean isVisible() {
		return true;
	}

}

