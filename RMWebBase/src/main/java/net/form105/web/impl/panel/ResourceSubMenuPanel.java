package net.form105.web.impl.panel;

import net.form105.web.base.HomePage;
import net.form105.web.base.component.menu.AbstractMenuPanel;
import net.form105.web.base.model.navigation.DefaultNavigationItem;

public class ResourceSubMenuPanel extends AbstractMenuPanel {

	private static final long serialVersionUID = 1L;
	
	public ResourceSubMenuPanel(String id) {
		super(id, "subNavigationList");
		addNavigationItem(new DefaultNavigationItem("allResources", HomePage.class, "menu.subNav.allResources"));
	}

	

}
