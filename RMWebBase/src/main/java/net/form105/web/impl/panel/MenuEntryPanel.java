package net.form105.web.impl.panel;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;

public class MenuEntryPanel extends Panel {

	private static final long serialVersionUID = 1L;

	public MenuEntryPanel(String id, String label, Class targetPage) {
		super(id);

		BookmarkablePageLink link = new BookmarkablePageLink("link", targetPage);
		link.add(new Label("label", label));
		add(link);

	}

}
