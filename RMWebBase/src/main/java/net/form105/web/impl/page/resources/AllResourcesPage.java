package net.form105.web.impl.page.resources;

import net.form105.web.base.template.DefaultMainTemplate;
import net.form105.web.impl.panel.ResourceSubMenuPanel;
import net.form105.web.impl.panel.contribution.NoContributionPanel;

public class AllResourcesPage extends DefaultMainTemplate {
	
	public AllResourcesPage() {
		super(new ResourceSubMenuPanel("panel.subNavigation", "menuItem", AllResourcesPage.class), new NoContributionPanel("panel.contribution"));
		
		//add(new StyleSheetReference("styleSheetResources", new ResourceReference(AllResourcesPage.class, "AllResourcesPage.css")));
	}

}
