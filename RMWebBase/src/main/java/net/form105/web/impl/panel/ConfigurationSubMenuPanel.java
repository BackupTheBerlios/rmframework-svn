package net.form105.web.impl.panel;

import net.form105.web.base.component.subMenu.SubMenuPanel;
import net.form105.web.impl.page.userManagement.UsersPage;

import org.apache.wicket.Page;

public class ConfigurationSubMenuPanel extends SubMenuPanel {

	private static final long serialVersionUID = 1L;
	
	public ConfigurationSubMenuPanel(String id, String menuId, Class<? extends Page> pageClass) {
		super(id, menuId, pageClass);
		
		addMenuEntry("menu.subNav.users", UsersPage.class);
		
	}

}
