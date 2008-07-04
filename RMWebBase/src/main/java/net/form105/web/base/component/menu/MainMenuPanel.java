package net.form105.web.base.component.menu;

import java.util.ArrayList;
import java.util.List;

import net.form105.web.base.HomePage;
import net.form105.web.base.component.login.LoginLinkPanel;
import net.form105.web.base.component.login.UserSwitchPanel;
import net.form105.web.base.model.navigation.DefaultNavigationItem;
import net.form105.web.base.model.navigation.INavigationItem;

import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.panel.Panel;

public class MainMenuPanel extends Panel<Object> {
	
	public static Logger logger = Logger.getLogger(MainMenuPanel.class);
	
	private List<INavigationItem> navList = new ArrayList<INavigationItem>();

	public MainMenuPanel(String id) {
		super(id);
        navList.add(new DefaultNavigationItem("navHome", HomePage.class, "menu.mainNav.home"));
        
        MainMenuListView listView = new MainMenuListView("mainNavList", navList);
        add(listView);
	}

	private static final long serialVersionUID = 1L;
	
	public void addEntry(INavigationItem item) {
		navList.add(item);
	}
}
