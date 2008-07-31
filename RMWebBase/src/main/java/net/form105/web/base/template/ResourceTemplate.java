package net.form105.web.base.template;

import net.form105.web.impl.page.login.LoginPage;

import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.html.resources.StyleSheetReference;

public class ResourceTemplate extends DefaultMainTemplate {
	
	public ResourceTemplate() {
		add(new StyleSheetReference("styleSheet", new ResourceReference(LoginPage.class, "BodyTemplate.css")));
	}

}
