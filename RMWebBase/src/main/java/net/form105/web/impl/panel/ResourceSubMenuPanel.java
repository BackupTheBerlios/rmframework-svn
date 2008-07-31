package net.form105.web.impl.panel;

import net.form105.web.impl.page.resources.AllResourcesPage;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;

public class ResourceSubMenuPanel extends Panel {

	private static final long serialVersionUID = 1L;

	public ResourceSubMenuPanel(String id) {
		super(id);
		
		//addNavigationItem(new DefaultNavigationItem("allResources", HomePage.class, "menu.subNav.allResources"));
		
		RepeatingView menu = new RepeatingView("menuItem");
		
		
		
		
		menu.add(new MenuEntryPanel(menu.newChildId(), "label1", AllResourcesPage.class));
		menu.add(new MenuEntryPanel(menu.newChildId(), "label2", AllResourcesPage.class));
		
		
		
		add(menu);
	}
		
		

	

}
