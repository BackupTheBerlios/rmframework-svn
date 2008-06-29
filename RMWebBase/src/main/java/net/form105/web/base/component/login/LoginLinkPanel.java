package net.form105.web.base.component.login;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.ResourceModel;

public class LoginLinkPanel extends Panel<Object> {
	
	/**
	 * 
	 */
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
		return true;
	}
}
