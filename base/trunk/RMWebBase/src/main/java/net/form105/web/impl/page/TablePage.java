package net.form105.web.impl.page;

import net.form105.web.base.component.subMenu.ExampleMenuPanel;
import net.form105.web.base.template.DefaultMainTemplate;
import net.form105.web.base.type.EventType;
import net.form105.web.impl.panel.contribution.NoContributionPanel;
import net.form105.web.impl.panel.tablePanel.JSTablePanel;

import org.apache.wicket.ajax.AjaxRequestTarget;

public class TablePage extends DefaultMainTemplate {

	public TablePage() {
		
		super(new ExampleMenuPanel("panel.subNavigation"), new NoContributionPanel("panel.contribution"));
		add(new JSTablePanel("panel.demoTable"));
	}

	@Override
	public void ajaxRequestReceived(AjaxRequestTarget target, Object modelObject, EventType type) {
		// TODO Auto-generated method stub

	}

}
