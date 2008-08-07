package net.form105.web.impl.page.template;

import net.form105.web.base.template.DefaultMainTemplate;
import net.form105.web.impl.panel.ConfigurationSubMenuPanel;

public class ConfigurationTemplate extends DefaultMainTemplate {
	
	public ConfigurationTemplate() {
		add(new ConfigurationSubMenuPanel("panel.subNavigation", "menuItem", this.getClass()));
	}

}
