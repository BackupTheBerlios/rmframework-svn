package net.form105.web.impl.page.resources;

import net.form105.web.base.component.subMenu.ExampleMenuPanel;
import net.form105.web.base.template.DefaultMainTemplate;
import net.form105.web.base.type.EventType;
import net.form105.web.impl.panel.contribution.NoContributionPanel;

import org.apache.wicket.ajax.AjaxRequestTarget;

public class AllResourcesPage extends DefaultMainTemplate {
	
	public AllResourcesPage() {
		super(new ExampleMenuPanel("panel.subNavigation"), new NoContributionPanel("panel.contribution"));
		
		//add(new StyleSheetReference("styleSheetResources", new ResourceReference(AllResourcesPage.class, "AllResourcesPage.css")));
	}

	@Override
	public void ajaxRequestReceived(AjaxRequestTarget target, Object modelObject, EventType type) {
		// TODO Auto-generated method stub
		
	}

}
