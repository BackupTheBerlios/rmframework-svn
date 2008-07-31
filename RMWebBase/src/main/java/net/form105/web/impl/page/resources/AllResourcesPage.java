package net.form105.web.impl.page.resources;

import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.html.resources.StyleSheetReference;

import net.form105.web.base.template.ResourceTemplate;
import net.form105.web.impl.page.login.LoginPage;

public class AllResourcesPage extends ResourceTemplate {
	
	public AllResourcesPage() {
		super();
		add(new StyleSheetReference("styleSheetResources", new ResourceReference(AllResourcesPage.class, "AllResourcesPage.css")));
	}

}
