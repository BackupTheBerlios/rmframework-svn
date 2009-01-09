package net.form105.web.impl.panel.contribution;

import org.apache.wicket.markup.html.panel.Panel;

/**
 * This is a placeholder for the contribution to load the stylesheet before the contribution part will be shown. 
 * The contribution panel will be replaced via ajax and so the stylesheet should be in place.
 * @author heiko
 *
 */
public class NoContributionPanel extends Panel {

	private static final long serialVersionUID = 1L;

	public NoContributionPanel(String id) {
		super(id);
		setOutputMarkupId(true);
	}
}
