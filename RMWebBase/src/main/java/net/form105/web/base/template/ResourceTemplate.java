package net.form105.web.base.template;

import net.form105.web.base.IAuthenticatedPage;
import net.form105.web.impl.panel.ResourceSubMenuPanel;

import org.apache.log4j.Logger;

public class ResourceTemplate extends DefaultMainTemplate implements IAuthenticatedPage {
	
	public static Logger logger = Logger.getLogger(ResourceTemplate.class);
	
	public ResourceTemplate() {
		logger.info("ResourceTemplate class: "+ this);
		add(new ResourceSubMenuPanel("panel.resourceSubNavigation", "menuItem", this.getClass()));	
	}
}
