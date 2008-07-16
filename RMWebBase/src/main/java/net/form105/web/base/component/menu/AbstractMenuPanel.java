package net.form105.web.base.component.menu;

import java.util.ArrayList;
import java.util.List;

import net.form105.web.base.model.navigation.INavigationItem;

import org.apache.wicket.markup.html.panel.Panel;

public class AbstractMenuPanel extends Panel<Void> {
	
	private static final long serialVersionUID = 1L;
	
	private List<INavigationItem> navList = new ArrayList<INavigationItem>();

	public AbstractMenuPanel(String id) {
		super(id);
		MainMenuListView listView = new MainMenuListView("mainNavList", navList);
		add(listView);
	}
	
	protected void addNavigationItem(INavigationItem item) {
		navList.add(item);
	}


}
