package net.form105.web.base.component.mainNavigation;

import net.form105.web.base.component.login.UserSwitchPanel;
import net.form105.web.base.component.menu.MainMenuPanel;

import org.apache.wicket.markup.html.panel.Panel;

public class MainNavigationPanel extends Panel {
	
	private static final long serialVersionUID = 1L;
	
	public MainNavigationPanel(String id) {
		super(id);
		add(new MainMenuPanel("panel.mainMenu", "mainNavList"));
		add(new UserSwitchPanel("panel.userSwitch"));
	}

}
