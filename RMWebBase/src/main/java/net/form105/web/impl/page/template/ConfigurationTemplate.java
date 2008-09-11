package net.form105.web.impl.page.template;

import net.form105.web.base.template.DefaultPageTemplate;
import net.form105.web.impl.panel.ConfigurationSubMenuPanel;

public class ConfigurationTemplate extends DefaultPageTemplate {
	
	public ConfigurationTemplate() {
		add(new ConfigurationSubMenuPanel("panel.subNavigation", "menuItem", this.getClass()));
	}

}
