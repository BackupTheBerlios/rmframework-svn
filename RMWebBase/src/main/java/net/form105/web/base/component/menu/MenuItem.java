package net.form105.web.base.component.menu;

import org.apache.wicket.markup.html.WebMarkupContainer;

public class MenuItem extends WebMarkupContainer {

	public MenuItem(String id) {
		super(id);
	}
	
	public String getMarkupId() {
		return "current";
	}
	
	public boolean isVisible() {
		return true;
	}

}
