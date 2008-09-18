package net.form105.web.impl.page.resources;

import org.apache.wicket.ajax.AjaxRequestTarget;

import net.form105.web.base.template.DefaultMainTemplate;
import net.form105.web.base.type.EventType;
import net.form105.web.impl.panel.ResourceSubMenuPanel;
import net.form105.web.impl.panel.contribution.NoContributionPanel;

public class AllResourcesPage extends DefaultMainTemplate {
	
	public AllResourcesPage() {
		super(new ResourceSubMenuPanel("panel.subNavigation", "menuItem", AllResourcesPage.class), new NoContributionPanel("panel.contribution"));
		
		//add(new StyleSheetReference("styleSheetResources", new ResourceReference(AllResourcesPage.class, "AllResourcesPage.css")));
	}

	@Override
	public void ajaxRequestReceived(AjaxRequestTarget target, Object modelObject, EventType type) {
		// TODO Auto-generated method stub
		
	}

}
