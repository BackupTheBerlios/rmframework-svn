package net.form105.web.base.template;

import net.form105.web.base.IAuthenticatedPage;
import net.form105.web.impl.panel.ResourceSubMenuPanel;

public class ResourceTemplate extends DefaultMainTemplate implements IAuthenticatedPage {
	
	public ResourceTemplate() {
		//add(new StyleSheetReference("styleSheet", new ResourceReference(ResourceTemplate.class, "ResourceTemplate.css")));
		add(new ResourceSubMenuPanel("panel.resourceSubNavigation"));
	}
}
