package net.form105.web.impl.panel;

import net.form105.web.base.HomePage;
import net.form105.web.impl.page.resources.AllResourcesPage;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.panel.Panel;

public class ResourceSubMenuPanel extends Panel {

	private static final long serialVersionUID = 1L;
	
	public ResourceSubMenuPanel(String id, String menuId, Class<? extends Page> pageClass) {
		super(id);
		
		//addMenuEntry("menu.subNav.allResources", AllResourcesPage.class);
		//addMenuEntry("menu.subNav.specialResources", HomePage.class);

	}
}
