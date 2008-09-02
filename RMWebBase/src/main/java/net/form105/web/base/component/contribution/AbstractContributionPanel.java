package net.form105.web.base.component.contribution;

import net.form105.web.base.component.border.BorderedPanel;

import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.html.resources.StyleSheetReference;

public abstract class AbstractContributionPanel extends BorderedPanel {
	
	private static final long serialVersionUID = 1L;

	public AbstractContributionPanel(String id) {
		super(id);
		add(new StyleSheetReference("contributionStylesheet", new ResourceReference(AbstractContributionPanel.class, "ContributionPanel.css")));
	}
}
