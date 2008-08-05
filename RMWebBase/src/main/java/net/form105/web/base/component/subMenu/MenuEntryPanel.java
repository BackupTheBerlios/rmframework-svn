package net.form105.web.base.component.subMenu;

import org.apache.log4j.Logger;
import org.apache.wicket.Page;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.ResourceModel;

public class MenuEntryPanel extends Panel {
	
	public static Logger logger = Logger.getLogger(MenuEntryPanel.class);

	private static final long serialVersionUID = 1L;

	public MenuEntryPanel(String id, String propertyKey, Class<? extends Page> targetPage, Class<? extends Page> currentPage) {
		super(id);
		
		BookmarkablePageLink link = new BookmarkablePageLink("link", targetPage);
		if (targetPage == currentPage) {
			setMarkupId("menuLinkActive");
			setOutputMarkupId(true);
		}
		
		ResourceModel rModel = new ResourceModel(propertyKey);
		link.add(new Label("label", rModel));
		add(link);
	}

}
