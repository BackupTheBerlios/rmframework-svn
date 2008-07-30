package net.form105.web.base.component.menu;

import net.form105.web.base.HomePage;
import net.form105.web.base.model.navigation.DefaultNavigationItem;

import org.apache.log4j.Logger;

public class MainMenuPanel extends AbstractMenuPanel {
	
	private static final long serialVersionUID = 1L;
	
	public static Logger logger = Logger.getLogger(MainMenuPanel.class);

	public MainMenuPanel(String id, String listId) {
		super(id, listId);
		addNavigationItem(new DefaultNavigationItem("navHome", HomePage.class, "menu.mainNav.home"));
	}
}
