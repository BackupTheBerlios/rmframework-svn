package net.form105.web.impl.panel;

import net.form105.web.impl.page.resources.AllResourcesPage;

import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.html.resources.StyleSheetReference;
import org.apache.wicket.markup.repeater.RepeatingView;

public class ResourceSubMenuPanel extends Panel {

	private static final long serialVersionUID = 1L;

	public ResourceSubMenuPanel(String id) {
		super(id);
		
		add(new StyleSheetReference("cssResourceSubMenuPanel", new ResourceReference(ResourceSubMenuPanel.class, "ResourceSubMenuPanel.css")));
		
		
		RepeatingView menu = new RepeatingView("menuItem");
		menu.add(new MenuEntryPanel(menu.newChildId(), "menu.subNav.allResources", AllResourcesPage.class));
		menu.add(new MenuEntryPanel(menu.newChildId(), "menu.subNav.specialResources", AllResourcesPage.class));
		add(menu);
	}
}
