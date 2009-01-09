package net.form105.web.base.component.contribution;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public abstract class AbstractContributionPanel extends Panel {
	
	private static final long serialVersionUID = 1L;

	public AbstractContributionPanel(String id, IModel headerModel) {
		super(id);
		add(new Label("contributionHeader", headerModel));
	}
}
