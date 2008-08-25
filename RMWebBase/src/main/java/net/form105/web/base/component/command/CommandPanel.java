package net.form105.web.base.component.command;

import java.util.List;

import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.html.resources.StyleSheetReference;
import org.apache.wicket.markup.repeater.RepeatingView;

public class CommandPanel extends Panel {
	
	private static final long serialVersionUID = 1L;

	private List<SubmitLink> linkList;
	
	public CommandPanel(String id, List<SubmitLink> linkList) {
		super(id);
		this.linkList = linkList;
		
		add(new StyleSheetReference("commandPanelStylesheet", new ResourceReference(CommandPanel.class,"CommandPanel.css")));
		
		
		RepeatingView rView = new RepeatingView("commandLabels");
		for (SubmitLink link : linkList) {
			rView.add(link);
		}
		
	}
	
	
	
	

}
