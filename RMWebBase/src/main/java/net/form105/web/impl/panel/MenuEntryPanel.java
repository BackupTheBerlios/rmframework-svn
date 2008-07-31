package net.form105.web.impl.panel;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.ResourceModel;

public class MenuEntryPanel extends Panel {

	private static final long serialVersionUID = 1L;

	public MenuEntryPanel(String id, String propertyKey, Class targetPage) {
		super(id);

		BookmarkablePageLink link = new BookmarkablePageLink("link", targetPage);
		ResourceModel rModel = new ResourceModel(propertyKey);
		link.add(new Label("label", rModel));
		add(link);

	}

}
