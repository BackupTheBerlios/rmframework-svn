package net.form105.web.base.component.login;

import org.apache.wicket.Session;
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
		ResourceModel rModel = new ResourceModel("login name comes here");
		new BookmarkablePageLink("navigationItem", LoginPage.class).add(new Label("navigationLabel", rModel));
		Session session = getSession();
		
	}

}
