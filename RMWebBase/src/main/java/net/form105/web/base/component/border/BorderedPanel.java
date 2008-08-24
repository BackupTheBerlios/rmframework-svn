package net.form105.web.base.component.border;

import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.html.resources.StyleSheetReference;

public class BorderedPanel extends Panel {
	
	private static final long serialVersionUID = 1L;

	public BorderedPanel(String id) {
		super(id);
		add(new StyleSheetReference("cssBorderedPanel", new ResourceReference(BorderedPanel.class, "BorderedPanel.css")));
	}

	

}
