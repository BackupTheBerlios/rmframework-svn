package net.form105.web.impl.panel.contribution;

import net.form105.web.base.component.contribution.AbstractContributionPanel;

import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.html.resources.StyleSheetReference;

/**
 * This is a placeholder for the contribution to load the stylesheet before the contribution part will be shown. 
 * The contributoin panel will be replaced via ajax and so the stylesheet should be in place.
 * @author heiko
 *
 */
public class NoContributionPanel extends Panel {

	private static final long serialVersionUID = 1L;

	public NoContributionPanel(String id) {
		super(id);
		add(new StyleSheetReference("contributionStylesheet", new ResourceReference(AbstractContributionPanel.class, "ContributionPanel.css")));
		setOutputMarkupId(true);
	}
}
