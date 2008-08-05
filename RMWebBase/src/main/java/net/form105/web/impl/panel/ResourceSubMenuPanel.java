package net.form105.web.impl.panel;

import org.apache.wicket.Page;

import net.form105.web.base.HomePage;
import net.form105.web.impl.page.resources.AllResourcesPage;

public class ResourceSubMenuPanel extends SubMenuPanel {

	private static final long serialVersionUID = 1L;
	
	public ResourceSubMenuPanel(String id, String menuId, Class<? extends Page> currentPage) {
		super(id, menuId, currentPage);
		
		addMenuEntry("menu.subNav.allResources", AllResourcesPage.class);
		addMenuEntry("menu.subNav.specialResources", HomePage.class);

	}
}
